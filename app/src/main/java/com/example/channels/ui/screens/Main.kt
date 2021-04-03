package com.example.channels.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.channels.R
import com.example.channels.data.entities.Channel
import com.example.channels.ui.components.ChannelsList

@Composable
fun MainScreen() {
    val channels = listOf(
        Channel(imageId = R.drawable.channel1, name = "Матч"),
        Channel(imageId = R.drawable.channel1, name = "Матч"),
        Channel(imageId = R.drawable.channel1, name = "Матч"),
        Channel(imageId = R.drawable.channel0, name = "Первый"),
        Channel(imageId = R.drawable.channel2, name = "Россия 1"),
        Channel(imageId = R.drawable.channel2, name = "Россия 1"),
        Channel(imageId = R.drawable.channel2, name = "Россия 1"),
    )
    var primaryChannelId by remember { mutableStateOf(3) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ChannelsList(
            channels = channels,
            primaryChannelId = primaryChannelId,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            TextButton(
                onClick = {
                    primaryChannelId =
                        (primaryChannelId - 1).takeIf { it >= 0 } ?: channels.size - 1
                }
            ) {
                Text(text = "PREVIOUS")
            }
            Spacer(modifier = Modifier.width(16.dp))
            TextButton(
                onClick = {
                    primaryChannelId = (primaryChannelId + 1).takeIf { it < channels.size } ?: 0
                }
            ) {
                Text(text = "NEXT")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = primaryChannelId.toString())
    }
}