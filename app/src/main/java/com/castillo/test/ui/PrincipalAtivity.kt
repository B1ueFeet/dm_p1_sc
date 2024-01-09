package com.castillo.test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.castillo.test.R
import com.castillo.test.data.entities.local.entities.User
import com.castillo.test.databinding.ActivityPrincipalBinding
import com.castillo.test.logic.usercase.jikan.JikanGetTopAnimesUserCase
import com.castillo.test.logic.usercase.local.LoginUserCase
import com.castillo.test.ui.core.Constants
import com.castillo.test.ui.core.My_Application
import com.castillo.test.ui.fragment.FavoritesFragment
import com.castillo.test.ui.fragment.ListFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrincipalAtivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
        chckDataBase()
        initRecyclerView()
        getAllTopAnimes()
    }
    private fun getAllTopAnimes(){
        lifecycleScope.launch(Dispatchers.IO) {

        }
    }
    private fun initRecyclerView() {
        lifecycleScope.launch(Dispatchers.Main) {
            binding.pbPrincipal.visibility= View.VISIBLE
            val usrs = withContext(Dispatchers.IO){ JikanGetTopAnimesUserCase().getResponse().data}
            val adapter: UserAdapter = UserAdapter(usrs)
            binding.rvUser.adapter = adapter
            binding.rvUser.layoutManager = LinearLayoutManager(this@PrincipalAtivity, LinearLayoutManager.VERTICAL, false )
            binding.pbPrincipal.visibility= View.GONE
        }
    }

    private suspend fun getUserList() : List<User>{
        delay(7000)
        return LoginUserCase(My_Application.getConnectionDB()!!).getAllUsers()
    }

    fun initListeners() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val transaction = supportFragmentManager.beginTransaction()
            when (item.itemId) {
                R.id.it_home -> {
                    transaction.replace(binding.frmContainer.id, ListFragment())
                    transaction.commit()
                    true
                }

                R.id.it_fav -> {
                    transaction.replace(binding.frmContainer.id, FavoritesFragment())
                    transaction.commit()
                    true
                }

                else -> {
                    lifecycleScope.launch(Dispatchers.Main) {
                        val name = withContext(Dispatchers.IO) {
                            getName()
                        }
                        binding.txtUsrName.text = name
                        binding.bottomNavigation


                    }
                    false
                }
            }
        }
    }

    fun chckDataBase () {
        lifecycleScope.launch (Dispatchers.Main) {
            val usrs = withContext(Dispatchers.IO){
                LoginUserCase(My_Application.getConnectionDB()!!).getAllUsers()
            }
            Log.d(Constants.TAG, usrs.toString())
        }

        /*lifecycleScope.launch(Dispatchers.IO) {
            val usrs = LoginUserCase(My_Application.getConnectionDB()!!).getAllUsers()
            withContext(Dispatchers.Main){
                usrs
            }
        }*/


    }
    suspend fun getName():String{
        val a ="Serghy "

        val b = a +"Castillo"

        return a//esto es lo que se va a devolver
    }
}