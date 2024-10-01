package com.karolisstuff.cryptoapp.data.repository

import com.karolisstuff.cryptoapp.data.remote.CoinPaprikaApi
import com.karolisstuff.cryptoapp.data.remote.dto.CoinDetailDto
import com.karolisstuff.cryptoapp.data.remote.dto.CoinDto
import com.karolisstuff.cryptoapp.data.remote.dto.CoinTweetDto
import com.karolisstuff.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto>{
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String) : CoinDetailDto{

        return api.getCoinById(coinId)
    }

    override suspend fun getTweetsById(coinId: String): List<CoinTweetDto> {
        return api.getTweetsById(coinId)
    }

}