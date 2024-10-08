package com.karolisstuff.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.karolisstuff.cryptoapp.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val is_active: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        is_Active = is_active,
        name = name,
        rank = rank,
        symbol = symbol)
}