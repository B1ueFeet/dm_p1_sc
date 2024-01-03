package com.castillo.test.logic.usercase.jikan

import android.util.Log
import com.castillo.test.data.network.endpoints.AnimeEndPoint
import com.castillo.test.data.network.endpoints.RetroFitBase
import com.castillo.test.logic.usercase.jikan.entities.FullInfoAnimeLG
import com.castillo.test.ui.core.Constants

class JikanUserCase {
    fun getAnimeFull(id:Int) : FullInfoAnimeLG{
        val baseService = RetroFitBase.getJikanConecction()
        val service = baseService.create(AnimeEndPoint::class.java)
        val call = service.getAnimeFull(id)
        val infoAnime : FullInfoAnimeLG = FullInfoAnimeLG()
        if(call.isSuccessful){
            infoAnime.id = call.body()!!.data.mal_id
            infoAnime.name = call.body()!!.data.title_english
            infoAnime.small_image = call.body()!!.data.images.jpg.small_image_url
            infoAnime.big_image = call.body()!!.data.images.jpg.small_image_url
        }else{
            Log.d(Constants.TAG, "error en el llamado de la appi de Jikan")
        }
        return  infoAnime
    }
}