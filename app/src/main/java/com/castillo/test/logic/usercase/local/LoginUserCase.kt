package com.castillo.test.logic.usercase.local

import android.util.Log
import com.castillo.test.data.entities.local.entities.User
import com.castillo.test.data.entities.local.repository.DBUsers
import com.castillo.test.data.entities.local.repository.DataBaseRepo
import com.castillo.test.ui.core.Constants

class LoginUserCase (val connection: DataBaseRepo) {
    fun checkUserPassword(user: String, password: String): Boolean {
        val users= DBUsers().getUserList()
        val lstusers = users.filter {
            it.password.equals(password) && it.userName.equals(user)
        }
        Log.d(Constants.TAG, lstusers.toString())
        return lstusers.isNotEmpty()
    }

    fun checkId (user: String): Int {
        var ret = -1
        val users= DBUsers().getUserList()
        val auxUser = users.filter {
            it.userName.equals(user)
        }
        if (auxUser.isNotEmpty()){
            ret = auxUser.first().userId
        }
        Log.d(Constants.TAG, ret.toString())
        return ret
    }
    fun getUserName(id:Int): User = DBUsers().getUserList().first {it.userId == id}

    suspend fun insertUser()=
        if(connection.getUserDAO().getAllUsers().isEmpty()){
            connection.getUserDAO().insertUser(
                DBUsers().getUserList()
            )
        }else{

        }
    suspend fun getAllUsers() : List<User> = connection.getUserDAO().getAllUsers()
}