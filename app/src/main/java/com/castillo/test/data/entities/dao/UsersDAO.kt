package com.castillo.test.data.entities.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.castillo.test.data.entities.entities.User

@Dao
interface UsersDAO {
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>
    @Query("SELECT * FROM User WHERE id = :id")
    fun getUserById(id: Int ): User
    @Insert
    fun insertUsers(users: List<User>)
    @Update
    fun updateUsers(users: List<User>)
    //HACER EL DELETE
}