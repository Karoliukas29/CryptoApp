package com.karolisstuff.cryptoapp.presentation.coin_detail

import com.karolisstuff.cryptoapp.domain.model.Tweet

data class CoinTweetState(
    val isLoading: Boolean = false,
    val tweets: List<Tweet> = emptyList(),
    val error: String = ""
)