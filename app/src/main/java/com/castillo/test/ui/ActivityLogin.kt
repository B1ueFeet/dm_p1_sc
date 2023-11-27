package com.castillo.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.castillo.test.R
import com.castillo.test.databinding.ActivityLogginBinding
import com.castillo.test.logic.login.SingIn
import com.castillo.test.ui.core.Constants
import com.google.android.material.snackbar.Snackbar

class ActivityLogin : AppCompatActivity() {
    private lateinit var binding:ActivityLogginBinding
    private val singIn: SingIn = SingIn()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loggin)
        binding = ActivityLogginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initControls()

    }

    fun initControls(){

        binding.btnLogin.setOnClickListener{
            var u = binding.etUser.text.toString()
            var p = binding.etPassword.text.toString()
            var conect = singIn.checkUserPassword(u,p)
            //Toast.makeText(this, u, Toast.LENGTH_SHORT).show()
            if(!conect){
                Snackbar.make(binding.btnLogin, "Incorrecto", Snackbar.LENGTH_LONG).show()
                binding.etUser.text.clear()
                binding.etPassword.text.clear()
            }else{
                val intent_exp = Intent(this, MainActivity::class.java)
                intent_exp.putExtra(Constants.TEXT_VARIABLE, u)
                startActivity(intent_exp)
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
    }
}