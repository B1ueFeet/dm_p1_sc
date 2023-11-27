package com.castillo.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.castillo.test.R
import com.creative.ipfyandroid.Ipfy
import com.creative.ipfyandroid.IpfyClass
import com.castillo.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Ipfy.init(this) // this is a context of application
        //or you can also pass IpfyClass type to get either IPv4 address only or universal address IPv4/v6 as
        Ipfy.init(this, IpfyClass.IPv4) //to get only IPv4 address
        //and
        Ipfy.init(this,IpfyClass.UniversalIP) //to get Universal address in IPv4/v6

        getIpAddress()
    }

    override fun onStart() {
        super.onStart()
        returnLogin()
        getAndShowName()
    }

    fun returnLogin(){
        binding.btnReturn.setOnClickListener{

            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
        }
    }

    fun getIpAddress(){
        Ipfy.getInstance().getPublicIpObserver().observe(this, { ipData ->

            binding.txt_ip.text=
                ipData.currentIpAddress // this is a value which is your current public IP address, null if no/lost internet connection
        })
    }

    fun getAndShowName(){
        val intent = getIntent()
        binding.txt_msj.text =getString(R.string.txtBnv, intent.getStringExtra("user"))
    }


}