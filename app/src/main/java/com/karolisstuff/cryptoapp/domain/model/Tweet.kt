package com.karolisstuff.cryptoapp.domain.model

data class Tweet(

    val date: String,
    val isRetweet: Boolean,
    val likeCount: Int,
    val mediaLink: String?,
    val retweetCount: Int,
    val status: String,
    val userName: String,
)
