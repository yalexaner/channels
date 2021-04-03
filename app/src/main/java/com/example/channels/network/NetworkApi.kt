package com.example.channels.network

import com.example.channels.network.entities.Group
import retrofit2.http.GET

interface NetworkApi {

    @GET("tv/group/")
    suspend fun getGroup(): List<Group>
}