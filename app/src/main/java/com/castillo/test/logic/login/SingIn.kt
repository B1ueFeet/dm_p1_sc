package com.castillo.test.logic.login

class SingIn {
    fun checkUserPassword(user: String, password: String): Boolean {

        if (user == "admin") {
            if (password == "admin") {
                return true
            }
        }
        return false
    }
}