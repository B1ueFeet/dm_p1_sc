package com.castillo.test.data.entities.repository

import com.castillo.test.data.entities.Users

class DBUsers {

    fun getListUsers():List<Users>{
        return  listOf<Users>(
            Users(0,"admin","admin"),
            Users(1, "socastillo", "12345"),
            Users(2, "wadiaz", "11111"),
            Users(3, "lcibarra", "00000"),
            Users(4, "lcibarra", "00000"),)
    }
}