package com.karolisstuff.cryptoapp.domain.use_case.get_tweets

import android.util.Log
import com.karolisstuff.cryptoapp.common.Resource
import com.karolisstuff.cryptoapp.data.remote.dto.toTweet
import com.karolisstuff.cryptoapp.domain.model.Tweet
import com.karolisstuff.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTweetsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<List<Tweet>>> = flow {
        Log.d("GetTweetsUseCase", "-----------------Making API call for coinId: $coinId") // Log coinId to verify format
        try {
            emit(Resource.Loading<List<Tweet>>())
            val tweets = repository.getTweetsById(coinId).map { it.toTweet() }
            emit(Resource.Success<List<Tweet>>(tweets))
        } catch (e: HttpException) {
            Log.e("GetTweetsUseCase", "---------------------HTTP error for coinId: $coinId, Error: ${e.localizedMessage}")
            emit(Resource.Error<List<Tweet>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            Log.e("GetTweetsUseCase", "-----------------------Network error for coinId: $coinId, Error: ${e.localizedMessage}")
            emit(Resource.Error<List<Tweet>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
