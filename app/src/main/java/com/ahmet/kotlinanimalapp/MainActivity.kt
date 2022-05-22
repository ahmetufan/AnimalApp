package com.ahmet.kotlinanimalapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ahmet.kotlinanimalapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId){
                R.id.navigation_home -> {
                    title = "Hayvan Rehberi"
                    navController.navigate(R.id.navigation_home)
                    true
                }

                R.id.navigation_dashboard -> {
                    title = "Bakım"
                    navController.navigate(R.id.navigation_dashboard)
                    true
                }
                R.id.notificationsFragment -> {
                    title = "Irklar"
                    navController.navigate(R.id.notificationsFragment)
                    true
                }
                R.id.navigation_bilgi -> {
                    title = "Gerekenler"
                    navController.navigate(R.id.navigation_bilgi)
                    true
                }
                else -> {
                    navController.navigate(R.id.navigation_home)
                    true
                }
            }
        }

    }
}