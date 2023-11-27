package com.castillo.test.logic.login

import com.castillo.test.data.entities.repository.DBUsers

class SingIn {
    fun checkUserPassword(user: String, password: String): Boolean {
        var users= DBUsers().getListUsers()
        for (i in users){
            if(i.userName.equals(user) and i.password.equals(password))
                return true

        }
        return false
    }
}