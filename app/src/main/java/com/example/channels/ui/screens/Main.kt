package com.example.channels.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.channels.data.MainViewModel
import com.example.channels.ui.components.ChannelsList
import com.example.channels.ui.components.ControlButtons

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val channels by viewModel.channels.observeAsState()
    val primaryChannelId by viewModel.primaryChannelIdx.observeAsState(0)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (channels != null) {
            ChannelsList(
                channels = channels!!,
                primaryChannelId = primaryChannelId,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        ControlButtons(onGoToPrevious = viewModel::goToPrevious, onGoToNext = viewModel::goToNext)
    }
}