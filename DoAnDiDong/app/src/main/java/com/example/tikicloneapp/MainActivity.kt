package com.example.tikicloneapp

import Fragment.HomeFragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.NotificationCompatExtras
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tikicloneapp.Fragment.DashboardFragment
import com.example.tikicloneapp.Fragment.NotificationsFragment
import com.example.tikicloneapp.Fragment.ProfileFragment
import com.example.tikicloneapp.Fragment.SearchFragment


class MainActivity : AppCompatActivity() {

    internal var selectedFragment : Fragment? =null
    private lateinit var textView: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_home -> {

                selectedFragment= HomeFragment()
            }
            R.id.navigation_dashboard -> {

                selectedFragment= DashboardFragment()
            }
            R.id.navigation_find -> {
                selectedFragment= SearchFragment()
            }
            R.id.navigation_notifications -> {
                selectedFragment= NotificationsFragment()
            }
            R.id.navigation_profile -> {
                selectedFragment= ProfileFragment()
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

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            ProfileFragment()

        ).commit()

    }
}