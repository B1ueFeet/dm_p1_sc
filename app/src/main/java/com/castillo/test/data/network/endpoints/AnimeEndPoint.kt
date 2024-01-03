package com.castillo.test.data.network.endpoints

import com.castillo.test.data.network.entities.jikan.anime.FullInfoAnime
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeEndPoint {
    @GET("anime/{id}/full")
    fun getAnimeFull(@Path("id") id : Int) : Response<FullInfoAnime>

}