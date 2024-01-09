package com.castillo.test.data.network.endpoints

import com.castillo.test.data.network.entities.jikan.top.TopAnime
import retrofit2.Response
import retrofit2.http.GET

interface TopAnimeEndpoint {
    @GET("top/anime")
    suspend fun  getAllTopAnimes(): Response<TopAnime>
}