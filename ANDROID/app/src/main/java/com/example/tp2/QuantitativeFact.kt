package com.example.tp2

sealed class QuantitativeFact(val value: Float, val rank: Rank) {
    abstract val unit: String
}
