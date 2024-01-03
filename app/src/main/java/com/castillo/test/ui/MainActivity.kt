package com.castillo.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.castillo.test.R
import com.creative.ipfyandroid.Ipfy
import com.creative.ipfyandroid.IpfyClass
import com.castillo.test.databinding.ActivityMainBinding
import com.castillo.test.ui.core.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private val loginUserCase: LoginUserCase = LoginUserCase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.extras.let{
            val usrId = it?.getInt(Constants.USR_ID)
            if (usrId != null){
                //getAndShowName(loginUserCase.getUserName(usrId).firstName)
            }else{
                returnLogin()
            }
        }

        Ipfy.init(this)
        Ipfy.init(this, IpfyClass.IPv4)
        Ipfy.init(this,IpfyClass.UniversalIP)
        getIpAddress()
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

    fun getIpAddress(){
        Ipfy.getInstance().getPublicIpObserver().observe(this, { ipData ->
            binding.txtIp.text=
                ipData.currentIpAddress
        })
    }

    fun getAndShowName(usr:String){
        binding.txtMsj.text =getString(R.string.txtBnv,usr)
    }


}