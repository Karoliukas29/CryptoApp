package com.karolisstuff.cryptoapp.data.remote

import com.karolisstuff.cryptoapp.data.remote.dto.CoinDetailDto
import com.karolisstuff.cryptoapp.data.remote.dto.CoinDto
import com.karolisstuff.cryptoapp.data.remote.dto.CoinTweetDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    @GET("/v1/coins/{coinId}/twitter")
    suspend fun getTweetsById(@Path("coinId") coinId: String): List<CoinTweetDto>
}