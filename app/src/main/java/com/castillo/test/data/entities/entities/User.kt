package com.castillo.test.data.entities.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val userName: String? ="",
    val password: String? ="")
{
    @PrimaryKey(autoGenerate = true)
    var id: Int =-1
    var firstName:String = "No Registrado"
    var lastName:String = "No Registrado"
    var profile:String = "User"
    constructor(id: Int, userName: String?,
                password: String?,profile : String
    ) :  this(userName,password)
    constructor(id: Int, userName: String?,
        password: String?): this(userName, password){
            this.id = id
        }

    constructor(id: Int,
                userName: String?,
                password: String?,
                firstName : String,
                lastName: String):this(
                    userName,
                    password,
                ){
                    this.id = id
                    this.firstName = firstName;
                    this.lastName = lastName
                }
}

