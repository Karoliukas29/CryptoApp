package com.karolisstuff.cryptoapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.karolisstuff.cryptoapp.domain.model.Tweet

data class CoinTweetDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("is_retweet")
    val isRetweet: Boolean,
    @SerializedName("like_count")
    val likeCount: Int,
    @SerializedName("media_link")
    val mediaLink: String,
    @SerializedName("retweet_count")
    val retweetCount: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("status_id")
    val statusId: String,
    @SerializedName("status_link")
    val statusLink: String,
    @SerializedName("user_image_link")
    val userImageLink: String,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("youtube_link")
    val youtubeLink: String
)

fun CoinTweetDto.toTweet(): Tweet {
    return Tweet(
        date = date,
        isRetweet = isRetweet,
        likeCount = likeCount,
        mediaLink = mediaLink ?: "",
        retweetCount = retweetCount,
        status = status,
        userName = userName
    )
}
