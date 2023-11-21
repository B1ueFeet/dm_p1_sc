package com.castillo.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.castillo.test.R
import com.castillo.test.databinding.ActivityLogginBinding
import com.castillo.test.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        returnLogin()
    }

    fun returnLogin(){
        binding.btnReturn.setOnClickListener{

            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
        }
    }


}