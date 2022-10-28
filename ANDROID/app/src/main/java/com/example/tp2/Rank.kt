package com.example.tp2

data class Rank(val position: Int, val maxPosition: Int) {
    val ratio get() = (maxPosition.toFloat() - position.toFloat()) / (maxPosition.toFloat() - 1f)
}
