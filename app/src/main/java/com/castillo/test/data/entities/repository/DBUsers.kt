package com.castillo.test.data.entities.repository

import com.castillo.test.data.entities.entities.User

class DBUsers {

    fun getListUsers():List<User>{
        return  listOf<User>(
            User(0,"admin","admin"),
            User(1, "socastillo", "12345"),
            User(2, "wadiaz", "11111"),
            User(3, "lcibarra", "00000"),
            User(4, "lcibarra", "00000"),)
    }
}