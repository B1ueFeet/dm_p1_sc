package com.castillo.test.data.network.endpoints

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitBase {
    private const val JIKAN_URL = "https://api.jikan.moe/v4/"
    fun getJikanConecction(): Retrofit {
        return Retrofit.Builder().baseUrl((JIKAN_URL)).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getNetflixConecction(): Retrofit {
        return Retrofit.Builder().baseUrl((JIKAN_URL)).addConverterFactory(GsonConverterFactory.create()).build()
    }
}