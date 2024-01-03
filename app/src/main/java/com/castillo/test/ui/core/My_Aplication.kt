package com.castillo.test.ui.core

import android.app.Application
import com.castillo.test.data.entities.local.repository.DBConnection
import com.castillo.test.data.entities.local.repository.DataBaseRepo
import com.castillo.test.logic.usercase.local.LoginUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class My_Application: Application() {

    override fun onCreate() {
        super.onCreate()
        con = DBConnection().getConnection(applicationContext)
        GlobalScope.launch (Dispatchers.IO){
            LoginUserCase(con).insertUser()
        }
    }

    companion object{
        private lateinit var con: DataBaseRepo
        fun getConnectionDB(): DataBaseRepo?{
            return con
        }
    }

}