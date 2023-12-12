package com.castillo.test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.castillo.test.R
import com.castillo.test.databinding.ActivityPrincipalBinding
import com.castillo.test.ui.fragment.FavoritesFragment
import com.castillo.test.ui.fragment.ListFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrincipalAtivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFragment = ListFragment()
        val favoritesFragment = FavoritesFragment()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.it_home -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(binding.frmContainer.id, listFragment)
                    transaction.commit()
                    true
                }

                R.id.it_fav -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(binding.frmContainer.id, favoritesFragment)
                    transaction.commit()
                    true
                }

                else -> {
                    lifecycleScope.launch(Dispatchers.Main) {

                        val s1 = async {
                            val a = ""
                        }
                        val listC = listOf(
                            async { getName() },
                            async { getName() },
                        )
                        val w = awaitAll(listC)
                        val name = withContext(Dispatchers.IO) {
                            getName()
                        }
                        binding.bottomNavigation

                    }
                    false
                }
            }
        }

    }
    suspend fun getName():String{
        val a ="Henry"

        val b = a +"Coyago"

        return a//esto es lo que se va a devolver
    }
}