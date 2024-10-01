package com.karolisstuff.cryptoapp.presentation.coin_detail

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
            getTweets(coinId)
        }
    }

    private fun getTweets(coinId: String) {
        getTweetsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinTweetState(tweets = result.data ?: emptyList())  // Assign the list of tweets
                }

                is Resource.Error -> {
                    _state.value = CoinTweetState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinTweetState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}


