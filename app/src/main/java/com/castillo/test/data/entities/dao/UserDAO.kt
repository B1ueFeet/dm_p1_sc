package com.castillo.test.data.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.castillo.test.data.entities.entities.User

@Dao
interface UserDAO {
    @Query("SElECT * FROM User")
    fun getAllUsers() : List<User>

    @Query("SElECT * FROM User WHERE userId = :userId ")
    fun getOneUser(userId: Int): User

    @Insert
    fun insertUser(users: List<User>)  // Inserta 1 o varios usuarios.

    @Update
    fun uddateUsers(users: List<User>) //
}