package com.example.channels.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    const val BASE_URL = "http://android.tv.planeta.tc:443"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api by lazy {
        retrofit.create(NetworkApi::class.java)
    }
}