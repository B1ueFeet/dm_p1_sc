package com.castillo.test.logic.login

import android.util.Log
import com.castillo.test.data.entities.Users
import com.castillo.test.data.entities.repository.DBUsers
import com.castillo.test.ui.core.Constants

class LoginUserCase {
    fun checkUserPassword(user: String, password: String): Boolean {
        val users= DBUsers().getListUsers()
        val lstusers = users.filter {
            it.password.equals(password) && it.userName.equals(user)
        }
        Log.d(Constants.TAG, lstusers.toString())
        return lstusers.isNotEmpty()
    }

    fun checkId (user: String): Int {
        var ret = -1
        val users= DBUsers().getListUsers()
        val auxUser = users.filter {
            it.userName.equals(user)
        }
        if (auxUser.isNotEmpty()){
            ret = auxUser.first().id
        }
        Log.d(Constants.TAG, ret.toString())
        return ret
    }
    fun getUserName(id:Int):Users = DBUsers().getListUsers().first {it.id == id}
}