package com.karolisstuff.cryptoapp.presentation.coin_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.karolisstuff.cryptoapp.domain.model.Tweet

@Composable
fun TweetItem(tweet: Tweet) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "User: ${tweet.userName}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Status: ${tweet.status}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Date: ${tweet.date}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (tweet.isRetweet) {
            Text(
                text = "Retweeted",
                style = MaterialTheme.typography.bodySmall,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        if (!tweet.mediaLink.isNullOrEmpty()) {
            Text(
                text = "Media: ${tweet.mediaLink}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                }
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Likes: ${tweet.likeCount}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Retweets: ${tweet.retweetCount}", style = MaterialTheme.typography.bodySmall)
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
    }
}
