package com.example.tp3

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3.Chronometer
import com.example.tp3.ui.theme.Tp3Theme
import kotlinx.coroutines.delay
import java.time.Instant

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tp3Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ChronoGame(expectedDuration = 10000L, onVerdict = {times -> {}})

                }
            }
        }
    }
}

/*
 * @param deltaTime in ms
 */
@Composable
fun DeltaTimeDisplayer(deltaTime: Long) {
    val minutes = (deltaTime / (1000 * 60) % 60)
    val seconds = (((deltaTime-(minutes*60000)) / 1000) % 60)
    val cents = (((deltaTime-(minutes*60000)-(seconds*1000)) / 10) % 100)

    val minutesStr = minutes.toString().padStart(2, '0')
    val secondsStr = seconds.toString().padStart(2, '0')
    val centsStr = cents.toString().padStart(2, '0')

    Text(
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        text= "$minutesStr:$secondsStr:$centsStr"
    )

}


@Composable
fun Chronometer(startTime: Long, endTime: Long = -1L) {
    var currentTime by remember { mutableStateOf(SystemClock.elapsedRealtime()) }
    LaunchedEffect(currentTime){
        currentTime = SystemClock.elapsedRealtime()
        delay(25)
    }
    DeltaTimeDisplayer((if (endTime == -1L) currentTime else endTime) - startTime)
}


@Composable
fun ChronometerManager() {
    var endTime by remember {
        mutableStateOf(0L)
    }
    var startTime by remember {
        mutableStateOf(0L)
    }
    Column() {
        Chronometer(startTime=startTime, endTime=endTime)
        Row() {
            Button(
                onClick = {
                    endTime=-1L
                    startTime = SystemClock.elapsedRealtime()
                }
            ) {
                Text(
                    color=Color.Black,
                    text="Start"
                )
            }
            Button(
                onClick = {
                    endTime=SystemClock.elapsedRealtime()

                }
            ) {
                Text(
                    color = Color.Black,
                    text="Stop"
                )
            }
        }
    }
}

@Composable
fun ChronoGame(expectedDuration: Long, onVerdict: (Long) -> Unit) {

    var endTime by remember {
        mutableStateOf(0L)
    }
    var startTime by remember {
        mutableStateOf(0L)
    }
    var visible by remember {
        mutableStateOf(false)
    }
    Column {
        DeltaTimeDisplayer(expectedDuration)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    IntrinsicSize.Min,
                )
                .defaultMinSize(
                    minHeight = 200.dp
                )
        ) {
            Surface(
                modifier = Modifier
                    .align(Alignment.Center)

            ) {
                Chronometer(
                    startTime = startTime,
                    endTime = endTime
                )
                if (visible)
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = "",
                        alignment = Alignment.Center,
                        contentScale = ContentScale.FillWidth
                    )
            }

        }


        Row() {
            Button(
                onClick = {
                    endTime=-1L
                    startTime = SystemClock.elapsedRealtime()
                }
            ) {
                Text(
                    color=Color.Black,
                    text="Start"
                )
            }
            Button(
                onClick = {
                    endTime=SystemClock.elapsedRealtime()
                    onVerdict(endTime-startTime)
                }
            ) {
                Text(
                    color = Color.Black,
                    text="Stop"
                )
            }
        }
    }
    LaunchedEffect(true) {
        while(true) {
            visible = endTime == -1L && SystemClock.elapsedRealtime() - startTime >= (expectedDuration / 2)
            delay(25)
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 412,
    heightDp = 915

)
@Composable
fun DefaultPreview() {
    Tp3Theme {
        ChronoGame(expectedDuration = 1000L, onVerdict = {time -> })
    }
}