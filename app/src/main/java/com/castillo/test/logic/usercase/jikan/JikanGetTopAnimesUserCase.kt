package com.castillo.test.logic.usercase.jikan

import android.util.Log
import com.castillo.test.data.network.endpoints.AnimeEndPoint
import com.castillo.test.data.network.endpoints.RetroFitBase
import com.castillo.test.data.network.endpoints.TopAnimeEndpoint
import com.castillo.test.data.network.entities.jikan.anime.getFullAnimeLG
import com.castillo.test.data.network.entities.jikan.top.TopAnime
import com.castillo.test.logic.usercase.jikan.entities.FullInfoAnimeLG
import com.castillo.test.ui.core.Constants

class JikanGetTopAnimesUserCase {

    suspend fun getResponse() : Result<TopAnime> {


        var result : Result<TopAnime>? = null

        var infoAnime = TopAnime()
        try {
            val baseService = RetroFitBase.getJikanConecction()
            val service = baseService.create(TopAnimeEndpoint::class.java)
            val call = service.getAllTopAnimes()

            if(call.isSuccessful){
                val a = call.body()!!
                infoAnime = a
                result = Result.success(infoAnime)
            }else{
                Log.e(Constants.TAG, "Error en el llamado del API Jikan")
                result = Result.failure(Exception("Error en el llamado del API Jikan"))
            }
        }catch (ex:Exception){
            Log.e(Constants.TAG, ex.stackTraceToString())
            result = Result.failure(ex)
        }
        return result!!
    }
}