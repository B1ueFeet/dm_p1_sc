package com.castillo.test.data.entities.repository

import com.castillo.test.data.entities.entities.User

class DBUsers {
    fun getUserList(): List<User> {
        /* NOTA:
           Puedo crear una instancia de Usuario, con cualquier constructor que tenga la clase,
           y luego añadir información de otras variables que no estaban en el constructor.*/
        val miUsuario = User("Roberto", "1234", "admin")
        miUsuario.lastName = "Manrique"
        miUsuario.userId = 22


        return listOf<User>(
            User("admin", "admin", 1,),
            User("j", "j", 2, "Juan Carlos", "Estrella"),
            User("maria", "maria", 3),
            miUsuario,
            User("jose", "1234", 20,"jose", "ramirez")
        )
    }
}