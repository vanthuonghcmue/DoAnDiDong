package com.example.tikicloneapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_home -> {
            textView.setText("Home ")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textView.setText("Dashboard ")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_find -> {
                textView.setText("Find ")

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textView.setText("notification ")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                textView.setText("Profile")
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        textView= findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}