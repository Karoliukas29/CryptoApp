package com.karolisstuff.cryptoapp.domain.repository

import com.karolisstuff.cryptoapp.data.remote.dto.CoinDetailDto
import com.karolisstuff.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}