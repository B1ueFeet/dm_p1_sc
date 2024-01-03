package com.castillo.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.castillo.test.R
import com.castillo.test.databinding.ActivityLogginBinding

class ActivityLogin : AppCompatActivity() {
    private lateinit var binding:ActivityLogginBinding
    //private val loginUserCase: LoginUserCase = LoginUserCase(this)

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
            val intent = Intent(this, PrincipalAtivity::class.java)
            startActivity(intent)
            /*var conect = loginUserCase.checkUserPassword(u,p)
            //Toast.makeText(this, u, Toast.LENGTH_SHORT).show()
            if(!conect){
                Snackbar.make(binding.btnLogin, "Incorrecto", Snackbar.LENGTH_LONG).show()
                binding.etUser.text.clear()
                binding.etPassword.text.clear()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                val uid = loginUserCase.checkId(u)
                intent.putExtra(Constants.USR_ID,uid)
                startActivity(intent)
            }*/
        }
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}