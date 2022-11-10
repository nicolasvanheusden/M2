package com.example.tp2

import androidx.compose.runtime.Composable
import java.util.*

data class Country(val name: String,
                   val areaFact: AreaFact,
                   val populationFact: PopulationFact,
                   val densityFact: DensityFact,
                   val perCapitalGDPFact: PerCapitalGDPFact,
                   val pictureID: Int,
                   val timeZone: TimeZone,
                   val latitude: Double,
                   val longitude: Double,
                   val flag: @Composable () -> Unit
                   )
