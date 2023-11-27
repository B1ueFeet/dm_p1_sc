package com.castillo.test.data.entities.repository

import com.castillo.test.data.entities.Users

class DBUsers {

    fun getListUsers():List<Users>{
        var usr0 = Users(0,"admin","admin")
        var usr1 = Users(1, "socastillo", "12345")
        var usr2 = Users(2, "wadiaz", "11111")
        var usr3 = Users(3, "lcibarra", "00000")
        var usr4 = Users(4, "lcibarra", "00000")
        var lstUsers = listOf(usr0,usr1,usr2,usr3,usr4)
        return lstUsers
    }
}