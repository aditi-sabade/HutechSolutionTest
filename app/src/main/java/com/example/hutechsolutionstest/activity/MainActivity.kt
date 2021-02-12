package com.example.hutechsolutionstest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.hutechsolutionstest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragNavHost) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.btm_nav_storeFragment, R.id.btm_nav_exploreFragment, R.id.btm_nav_cartFragment,
            R.id.btm_nav_favouriteFragment, R.id.btm_nav_accountFragment
        ))
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)

    }
}