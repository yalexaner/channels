package com.example.channels.data.entities

import androidx.annotation.DrawableRes

data class Channel(
    @DrawableRes val imageId: Int,
    val name: String
)