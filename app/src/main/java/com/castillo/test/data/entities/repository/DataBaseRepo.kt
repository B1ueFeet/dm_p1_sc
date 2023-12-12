package com.castillo.test.data.entities.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

class DBConnection(){
    fun getConnection(context: Context) : DataBaseRepo =
        Room.databaseBuilder(
            context,
            DataBaseRepo::class.java,
            "DBTest"
        ).build()

}