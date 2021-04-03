package com.example.channels.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.channels.data.entities.Channel

@Composable
fun ChannelsList(
    modifier: Modifier = Modifier,
    channels: List<Channel>,
    primaryChannelId: Int
) {
    CenteredList(modifier = modifier, centeredElementId = primaryChannelId) {
        channels.forEach { channel ->
            Channel(channel = channel, modifier = Modifier.padding(horizontal = 4.dp))
        }
    }
}

@Composable
private fun Channel(
    modifier: Modifier = Modifier,
    channel: Channel,
    primary: Boolean = false
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = channel.imageId),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .height(60.dp)
        )
        if (primary) {
            Text(text = channel.name)
        }
    }
}