package com.castillo.test.data.entities.repository

import androidx.room.Database
import com.castillo.test.data.entities.dao.UsersDAO
import com.castillo.test.data.entities.entities.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class DataBaseRepo {
    abstract fun getUserDAO() : UsersDAO
}