package com.karolisstuff.cryptoapp.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karolisstuff.cryptoapp.common.Constants
import com.karolisstuff.cryptoapp.common.Resource
import com.karolisstuff.cryptoapp.domain.use_case.get_tweets.GetTweetsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinTweetViewModel @Inject constructor(
    private val getTweetsUseCase: GetTweetsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinTweetState())
    val state: State<CoinTweetState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            Log.d("CoinTweetViewModel", "-------------------Fetching tweets for coinId: $coinId")

            getTweets(coinId)
        }
    }

    private fun getTweets(coinId: String) {
        getTweetsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("CoinTweetViewModel", "-----------------------Successfully fetched tweets for coinId: $coinId")
                    _state.value = CoinTweetState(tweets = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    Log.e("CoinTweetViewModel", "---------------------------Error fetching tweets for coinId: $coinId, Error: ${result.message}")
                    _state.value = CoinTweetState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    Log.d("CoinTweetViewModel", "-------------------------Loading tweets for coinId: $coinId")
                    _state.value = CoinTweetState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}


