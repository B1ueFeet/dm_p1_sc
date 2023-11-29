package com.castillo.test.data.entities.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.castillo.test.data.entities.dao.UsersDAO
import com.castillo.test.data.entities.entities.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class DataBaseRepo : RoomDatabase(){
    abstract fun getUserDAO() : UsersDAO
}