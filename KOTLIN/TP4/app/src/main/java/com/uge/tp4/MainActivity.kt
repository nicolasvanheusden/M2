
package com.uge.tp4

import android.content.Context
import android.graphics.RectF
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uge.tp4.ui.theme.TP4Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.stream.Collectors
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TP4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    displayLoadingMap(context = this)
                    
                }
            }
        }
    }
}

fun getTownListFlow(context: Context): Flow<TownListLoading> = flow<TownListLoading> {
    emit(TownListProgress())
    val towns = Town.parseFile(context, "laposte_hexasmal.csv").stream().collect(Collectors.toSet()).toList()
    emit(TownListResult(towns))

}

@Composable
fun displayLoadingMap(context: Context) {

    val townList = remember { mutableStateListOf<Town>() }
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(loading) {
        while (loading) {
            getTownListFlow(context = context).flowOn(Dispatchers.Default).collect {
                if (it is TownListResult){
                    townList.addAll(it.townList)
                    loading = false
                }
            }
        }
    }

    if (townList.isEmpty()) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                CircularProgressIndicator()
            }
        }



    } else {
        TownManager(allTowns = townList)
    }



}


@Composable
fun TownDisplayer(towns: List<Town>, circuit: List<Town>) {
    val mapBounds = RectF(-5.6126f /* min longitude */,
        51.8073f /* max latitude */,
        8.3117f /* max longitude */,
        41.3509f /* min latitude */)

    val bitmap = ImageBitmap.imageResource(id = R.drawable.france_map)

    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        textSize = 12f
        color = android.graphics.Color.BLUE
        typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
    }

    Box (
        modifier = Modifier
            .height(200.dp)
    ){
        Canvas(modifier = Modifier
            .fillMaxWidth(),
            onDraw = {
                drawImage(
                    bitmap,
                    topLeft = Offset(
                        (size.width-bitmap.width) / 2f,
                        (size.height-bitmap.height) / 2f
                    )
                )
                towns
                    .filter { it.zipcode.toInt() <= 96000 && !it.zipcode.startsWith("20") }
                    .forEach {
                        drawCircle(
                            color = Color.Black,
                            radius = 1F,
                            center = Offset(
                                x = (bitmap.width + (size.width-bitmap.width) / 2f) * (it.longitude - mapBounds.left) / (mapBounds.right - mapBounds.left),
                                y =  bitmap.height * (1f - (it.latitude - mapBounds.bottom) / (mapBounds.top - mapBounds.bottom)) + (size.height-bitmap.height) / 2f
                            )
                        )
                    }
                towns
                    .filter { it.zipcode.toInt() <= 96000 && !it.zipcode.startsWith("20") }
                    .forEach { town ->
                        drawIntoCanvas {
                            it.nativeCanvas.drawText(
                                town.name,
                                (bitmap.width + (size.width-bitmap.width) / 2f) * (town.longitude - mapBounds.left) / (mapBounds.right - mapBounds.left),
                                bitmap.height * (1f - (town.latitude - mapBounds.bottom) / (mapBounds.top - mapBounds.bottom)) + (size.height-bitmap.height) / 2f,
                                textPaint
                            )
                        }

                    }
                circuit.forEachIndexed {
                    index, town ->
                        val nextIndex = if (index + 1 >= circuit.size) 0 else (index+1)
                        val nextTown = circuit.get(nextIndex)
                        drawLine(
                            color = Color.Black,
                            start = Offset((bitmap.width + (size.width-bitmap.width) / 2f) * (town.longitude - mapBounds.left) / (mapBounds.right - mapBounds.left),
                                bitmap.height * (1f - (town.latitude - mapBounds.bottom) / (mapBounds.top - mapBounds.bottom)) + (size.height-bitmap.height) / 2f),
                            end = Offset((bitmap.width + (size.width-bitmap.width) / 2f) * (nextTown.longitude - mapBounds.left) / (mapBounds.right - mapBounds.left),
                                bitmap.height * (1f - (nextTown.latitude - mapBounds.bottom) / (mapBounds.top - mapBounds.bottom)) + (size.height-bitmap.height) / 2f)

                        )
                }
                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        circuit.circuitDistance().toString(),
                        250.0.toFloat(),
                        500.0.toFloat(),
                        textPaint
                    )
                }

            }
        )

    }

}




@Composable
fun TownManager(allTowns: List<Town>) {
    val townList = remember { mutableStateListOf<Town>() }
    var townNumber by remember { mutableStateOf(0) }
    val circuit = remember {
        mutableStateListOf<Town>()
    }

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        TownDisplayer(towns = townList, circuit)
        Slider(
            value= townNumber.toFloat(),
            valueRange = 0f..25f,
            steps = 25,
            enabled = true,
            onValueChange= {
                townNumber = it.roundToInt()
            }
        )
        TextButton(
            onClick = {
                if (circuit.size == 0) {
                    circuit.addAll(computeWithSimulatedAnnealing(
                        townList,
                        100_000,
                        SimulatedAnnealingParams(temperatureDecreaseRatio = 0.9)
                    )
                    )
                }
            },
            modifier= Modifier.
                    align(Alignment.CenterHorizontally)

        ) {
            Text(
                "Start"
            )
        }

    }

    LaunchedEffect(townNumber) {
        townList.clear()
        circuit.clear()
        townList.addAll(allTowns.shuffled().subList(0, townNumber).toList())
    }
}


@Composable
fun LongDisplayer() {
    var running by remember { mutableStateOf(false) } // set to true to start the flow
    var number by remember { mutableStateOf(-1L) }
    LaunchedEffect(running) {
        if (running)
            getLongFlow().flowOn(Dispatchers.Default).collect{number = it}
    }
    Column(Modifier.fillMaxWidth()) {
        Text("$number")
        Button(onClick = { running = true }, enabled=!running) {
            Text("Start")
        }
        Button(onClick = { running = false }, enabled=running) {
            Text("Stop")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TP4Theme {
    }
}