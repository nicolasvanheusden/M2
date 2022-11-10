package com.example.tp2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.example.tp2.ui.theme.TP2Theme
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants

import java.time.Instant
import java.util.*

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
    val countryList = listOf(
        Country(
            name = "France",
            areaFact = AreaFact(640679f, Rank(42, 195)),
            populationFact= PopulationFact(67939000f, Rank(20, 195)),
            densityFact = DensityFact(117f, Rank(99, 250)),
            perCapitalGDPFact= PerCapitalGDPFact(42330f, Rank(34, 216)),
            pictureID = R.drawable.paris,
            timeZone= TimeZone.getTimeZone("Europe/Paris"),
            latitude= 48.50,
            longitude = 2.20,
            flag={ FrenchFlag() }
        ),
        Country(
            name = "Chad",
            areaFact = AreaFact(1284000f , Rank(20, 195)),
            populationFact= PopulationFact(16818391f, Rank(70, 195)),
            densityFact = DensityFact(13f, Rank(226, 250)),
            perCapitalGDPFact= PerCapitalGDPFact(743f, Rank(207, 216)),
            pictureID = R.drawable.chad,
            timeZone= TimeZone.getTimeZone("Africa/Niamey"),
            latitude= 12.1131,
            longitude = 15.0492,
            flag={ ChadFlag() }
        ),
        Country(
            name = "Japan",
            areaFact = AreaFact(377976f , Rank(62, 195)),
            populationFact= PopulationFact(125927902f, Rank(11, 195)),
            densityFact = DensityFact(330f, Rank(41, 250)),
            perCapitalGDPFact= PerCapitalGDPFact(34358f, Rank(42, 216)),
            pictureID = R.drawable.japan,
            timeZone= TimeZone.getTimeZone("Asia/Tokyo"),
            latitude= 35.6894,
            longitude = 139.692,
            flag={ JapanFlag() }
        ),
        Country(
            name = "Bahamas",
            areaFact = AreaFact(13943f, Rank(155, 195)),
            populationFact= PopulationFact(393450f, Rank( 170, 195)),
            densityFact = DensityFact(29f, Rank(193, 250)),
            perCapitalGDPFact= PerCapitalGDPFact(32246f, Rank(47, 216)),
            pictureID = R.drawable.bahamas,
            timeZone= TimeZone.getTimeZone("America/Nassau"),
            latitude= 35.9964,
            longitude = 42.0036,
            flag={ BahamasFlag() }
        )
    )
    Scaffold() {
        Column {
            /*
            HelloWorldMessage(name = name, counter = counter)
            WorldMap(
                mapClick = { counter++ },
                mapDoubleClick = {counter += 4}
            )
            FrenchFlag()
            ChadFlag()
            JapanFlag()
            BahamasFlag()
             */
            CountryDisplayer(
                country=countryList.first()
            )

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


@Composable
fun RankedValueDisplayer(value: Float, unit: String, rank: Rank, name: String, dp: Dp) {
    Row(
        modifier=Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
           text=name,
        )
        Box(
            modifier = Modifier
                .width(dp)
                .border(width = 1.dp, color = Color.Black)
                .height(IntrinsicSize.Min)

        ) {
            Surface {
                Box(
                    modifier= Modifier
                        .background(color = Color.Green)
                        .fillMaxHeight()
                        .fillMaxWidth((rank.maxPosition.dp - rank.position.dp) / rank.maxPosition.dp)
                )

                Row (
                    modifier= Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Text(
                        text = "$value $unit",
                        color = Color.Black
                    )
                    Text(
                        text = "${rank.position}/${rank.maxPosition}",
                        color = Color.Black
                    )
                }
            }


        }
    }

}


@Composable
fun ClockDisplayer(tz: TimeZone) {
    var counter by rememberSaveable { mutableStateOf(0L) }
    val date = Date.from(Instant.now().atZone(tz.toZoneId()).toInstant().plusSeconds(counter))

    Text(
        "$date",
        fontSize = 20.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )

    LaunchedEffect(date) {
        delay(1000L) // convert to milliseconds
        counter++
    }
}


@Composable
fun ComputeWidth(labels: @Composable () -> Unit, content: @Composable (width: Dp) -> Unit) {
    SubcomposeLayout { constraints ->
        // on mesure la longueur des labels (on peut passer un Row { Text(...) Text(...) ... })
        val width = subcompose("labels") {
            labels()
        }[0].measure(Constraints()).width.toDp()
        // on réalise la mesure du contenu que l'on veut rendre en indiquant la longueur des labels
        val contentPlaceable = subcompose("content") { content(width) }[0].measure(constraints)
        // on réalise le rendu final en placant le contenu à son emplacement par défaut en haut à gauche
        layout(contentPlaceable.width, contentPlaceable.height) {
            contentPlaceable.place(0, 0)
        }
    }
}

@Composable
fun CountryDisplayer(country: Country) {
    Scaffold() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = country.name,
                color = Color.Black,
                fontSize = 24.sp
            )
            Row() {
                FlagDisplayer(country = country)
                Image(
                    painter = painterResource(country.pictureID),
                    contentDescription = "capital",
                )
            }
            
            ClockDisplayer(tz = country.timeZone)
            ComputeWidth(
                labels = {
                    Row {
                        Text("area")
                        Text("Population")
                        Text("density")
                        Text("GDP per capital")
                    }
                },
                content = {
                    RankedValueDisplayer(value = country.areaFact.value,
                        unit = country.areaFact.unit,
                        rank = country.areaFact.rank,
                        name = "area",
                        dp = it)
                }
            )
            ComputeWidth(
                labels = {
                    Row {
                        Text("area")
                        Text("Population")
                        Text("density")
                        Text("GDP per capital")
                    }
                },
                content = {
                    RankedValueDisplayer(
                        value = country.populationFact.value,
                        unit = country.populationFact.unit,
                        rank = country.populationFact.rank,
                        name = "Population",
                        dp = it)
                }
            )
            ComputeWidth(
                labels = {
                    Row {
                        Text("area")
                        Text("Population")
                        Text("density")
                        Text("GDP per capital")
                    }
                },
                content = {
                    RankedValueDisplayer(
                        value = country.densityFact.value,
                        unit = country.densityFact.unit,
                        rank = country.densityFact.rank,
                        name = "density",
                        dp = it)
                }
            )
            ComputeWidth(
                labels = {
                    Row {
                        Text("area")
                        Text("Population")
                        Text("density")
                        Text("GDP per capital")
                    }
                },
                content = {
                    RankedValueDisplayer(
                        value = country.perCapitalGDPFact.value,
                        unit = country.perCapitalGDPFact.unit,
                        rank = country.perCapitalGDPFact.rank,
                        name = "GDP per capital",
                        dp = it)
                }
            )

        }
    }
}


@Composable
fun FlagDisplayer(country: Country) {
    Column(
        horizontalAlignment=Alignment.CenterHorizontally,
    ) {
        country.flag.invoke()
        Text(country.name)
    }
}

@Composable
fun FlagsDisplayer(countries: List<Country>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(countries) { country ->
            FlagDisplayer(country = country)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TP2Theme {
        HelloWorld("Android")
    }
}




