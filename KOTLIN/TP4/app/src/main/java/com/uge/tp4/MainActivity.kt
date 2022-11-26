package com.uge.tp4

import android.graphics.RectF
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uge.tp4.ui.theme.TP4Theme
import java.util.stream.Collector
import java.util.stream.Collectors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val towns = Town.parseFile(this, "laposte_hexasmal.csv").stream().collect(Collectors.toSet())
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
                    TownDisplayer(towns = towns)
                }
            }
        }
    }
}

@Composable
fun TownDisplayer(towns: Set<Town>) {
    val MAP_BOUNDS = RectF(-5.6126f /* min longitude */,
        51.8073f /* max latitude */,
        8.3117f /* max longitude */,
        41.3509f /* min latitude */)

    val bitmap = ImageBitmap.imageResource(id = R.drawable.france_map)

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        onDraw = {
            drawImage(
                bitmap,
                topLeft = Offset(
                    (size.width-bitmap.width) / 2f,
                    (size.height-bitmap.height) / 2f
                )
            )
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TP4Theme {

    }
}