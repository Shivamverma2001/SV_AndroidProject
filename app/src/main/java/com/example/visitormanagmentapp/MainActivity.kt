package com.example.visitormanagmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar.NavigationMode
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation=findViewById<BottomNavigationView>(R.id.btm_nav)
        val navController= Navigation.findNavController(this,R.id.host_fragment1)
        NavigationUI.setupWithNavController(bottomNavigation,navController)
    }
}
