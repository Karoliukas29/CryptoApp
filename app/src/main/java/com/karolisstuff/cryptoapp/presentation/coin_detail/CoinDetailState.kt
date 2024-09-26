package com.karolisstuff.cryptoapp.presentation.coin_detail

import com.karolisstuff.cryptoapp.domain.model.Coin
import com.karolisstuff.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null ,
    val error: String = ""
)
