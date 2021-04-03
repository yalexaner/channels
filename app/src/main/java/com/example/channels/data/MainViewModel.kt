package com.example.channels.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.channels.network.NetworkClient
import com.example.channels.network.entities.Channel

class MainViewModel : ViewModel() {
    val channels: LiveData<List<Channel>> = liveData {
        val channels = NetworkClient.api.getGroup()[0].channels
        emit(channels)
    }

    private val _primaryChannelIdx = MutableLiveData(0)
    val primaryChannelIdx: LiveData<Int> get() = _primaryChannelIdx

    fun goToPrevious() {
        if (_primaryChannelIdx.value == 0) {
            _primaryChannelIdx.value = channels.value?.size ?: 0
        }

        _primaryChannelIdx.value = (_primaryChannelIdx.value?.minus(1))
    }

    fun goToNext() {
        if (_primaryChannelIdx.value == (channels.value?.size ?: 1) - 1) {
            _primaryChannelIdx.value = 0
        }

        _primaryChannelIdx.value = (_primaryChannelIdx.value?.plus(1))
    }
}