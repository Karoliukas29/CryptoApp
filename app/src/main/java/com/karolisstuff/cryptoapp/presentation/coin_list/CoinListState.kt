package com.karolisstuff.cryptoapp.presentation.coin_list

import com.karolisstuff.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
