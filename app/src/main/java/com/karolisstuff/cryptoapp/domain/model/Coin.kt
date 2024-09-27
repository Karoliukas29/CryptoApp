package com.karolisstuff.cryptoapp.domain.model


data class Coin(

    val id: String,
    val is_Active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
