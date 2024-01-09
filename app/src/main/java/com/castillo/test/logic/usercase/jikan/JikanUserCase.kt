package com.castillo.test.logic.usercase.jikan

import android.util.Log
import com.castillo.test.data.network.endpoints.AnimeEndPoint
import com.castillo.test.data.network.endpoints.RetroFitBase
import com.castillo.test.data.network.entities.jikan.anime.getFullAnimeLG
import com.castillo.test.logic.usercase.jikan.entities.FullInfoAnimeLG
import com.castillo.test.ui.core.Constants

class JikanUserCase {
    fun getAnimeFull(id:Int) : FullInfoAnimeLG{
        var infoAnime : FullInfoAnimeLG = FullInfoAnimeLG()
        try {
            val baseService = RetroFitBase.getJikanConecction()
            val service = baseService.create(AnimeEndPoint::class.java)
            val call = service.getAnimeFull(id)
            if(call.isSuccessful){
                val a = call.body()!!
                infoAnime = a.getFullAnimeLG()
            }else{
                Log.d(Constants.TAG, "error en el llamado de la appi de Jikan")
            }
        }catch (ex:Exception){

        }

        return  infoAnime
    }
    fun getAllTopsAnimes(){

    }
}