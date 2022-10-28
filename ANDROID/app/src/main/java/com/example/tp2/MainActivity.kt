package com.example.tp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp2.ui.theme.TP2Theme
import java.util.Stack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            TP2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HelloWorld("android")

                }
            }
        }
    }
}



@Composable
fun HelloWorld(name: String) {
    var counter by remember { mutableStateOf(0) }
    val countryList = listOf(
        Country(
            name = "France",
            areaFact = AreaFact(640679f, Rank(42, 195)),
            populationFact= PopulationFact(67939000f, Rank(20, 195)),
            densityFact = DensityFact(117f, Rank(99, 250)),
            perCapitalGDPFact= PerCapitalGDPFact(42330f, Rank(34, 216))
        ),
        Country(
            name = "Chad",
            areaFact = AreaFact(1284000f , Rank(20, 195)),
            populationFact= PopulationFact(16818391f, Rank(70, 195)),
            densityFact = DensityFact(13f, Rank(226, 250)),
            perCapitalGDPFact= PerCapitalGDPFact(743f, Rank(207, 216))
        ),
        Country(
            name = "Japan",
            areaFact = AreaFact(377976f , Rank(62, 195)),
            populationFact= PopulationFact(125927902f, Rank(11, 195)),
            densityFact = DensityFact(330f, Rank(41, 250)),
            perCapitalGDPFact= PerCapitalGDPFact(34358f, Rank(42, 216))
        ),
        Country(
            name = "Bahamas",
            areaFact = AreaFact(13943f, Rank(155, 195)),
            populationFact= PopulationFact(393450f, Rank( 170, 195)),
            densityFact = DensityFact(29f, Rank(193, 250)),
            perCapitalGDPFact= PerCapitalGDPFact(32246f, Rank(47, 216))
        )
    )
    Scaffold() {
        Column {
            HelloWorldMessage(name = name, counter = counter)
            WorldMap(
                mapClick = { counter++ },
                mapDoubleClick = {counter += 4}
            )
            FrenchFlag()
            ChadFlag()
            JapanFlag()
            BahamasFlag()

        }
    }

}

@Composable
fun HelloWorldMessage(name: String, counter: Int){
    Text(
        modifier= Modifier
            .background(Color.Red)
            .fillMaxWidth(),
        color=Color.White,
        text = "Hello $name! clicked : $counter"

    )
}

@Composable
fun WorldMap(mapClick: () -> Unit, mapDoubleClick: () -> Unit) {
    Image(
        painter = painterResource(R.drawable.equirectangular_world_map),
        contentDescription = "world map",
        modifier=
        Modifier
            .clickable { mapClick.invoke() }
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = { mapDoubleClick.invoke() },
                    onTap = { mapClick.invoke() }
                )
            }
    )
}


@Composable
fun FrenchFlag() {
    Row(
        modifier= Modifier
            .height(100.dp)
            .width(150.dp)
            .border(width = 1.dp, color = Color.Black)
    ) {
        Box (
            modifier= Modifier
                .fillMaxHeight()
                .background(Color.Blue)
                .width(50.dp)
        )
        Box (
            Modifier
                .fillMaxHeight()
                .background(Color.White)
                .width(50.dp)
        )
        Box (
            Modifier
                .fillMaxHeight()
                .background(Color.Red)
                .width(50.dp)
        )

    }
}

@Composable
fun ChadFlag() {
    Row(
        modifier= Modifier
            .height(100.dp)
            .width(150.dp)
            .border(width = 1.dp, color = Color.Black)
    ) {
        Box (
            modifier= Modifier
                .fillMaxHeight()
                .background(Color.Blue)
                .width(50.dp)
        )
        Box (
            Modifier
                .fillMaxHeight()
                .background(Color.Yellow)
                .width(50.dp)
        )
        Box (
            Modifier
                .fillMaxHeight()
                .background(Color.Red)
                .width(50.dp)
        )

    }
}

@Composable
fun JapanFlag() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            .background(color = Color.White)
            .border(width = 1.dp, color = Color.Black)
    ) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(CircleShape)
                .background(color = Color.Red)
        )
    }
}

@Composable
fun BahamasFlag() {
    val triangleShape = GenericShape { size, _ ->
        moveTo(0f, 0f)
        lineTo(100f, size.height / 2)
        lineTo(0f, size.height)
        lineTo(0f, 0f)
        close()
    }
    Surface(
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            .border(width = 1.dp, color = Color.Black)
    )
    {
        Column() {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height((100 / 3).dp)
                    .background(color = Color.Cyan)

            )
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height((100 / 3).dp)
                    .background(color = Color.Yellow)
            )
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height((100 / 3).dp)
                    .background(color = Color.Cyan)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(10.dp)
                .clip(triangleShape)
                .background(color = Color.Black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TP2Theme {
        HelloWorld("Android")
    }
}