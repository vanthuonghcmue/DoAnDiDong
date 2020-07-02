package com.example.tikicloneapp

import Fragment.HomeFragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.tikicloneapp.Fragment.DashboardFragment
import com.example.tikicloneapp.Fragment.NotificationsFragment
import com.example.tikicloneapp.Fragment.ProfileFragment
import com.example.tikicloneapp.Fragment.SearchFragment

class MainActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_home -> {
                moveToFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                moveToFragment(DashboardFragment())
                return@OnNavigationItemSelectedListener true


            }
            R.id.navigation_find -> {
                moveToFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true



            }
            R.id.navigation_notifications -> {
                moveToFragment(NotificationsFragment())
                return@OnNavigationItemSelectedListener true


            }
            R.id.navigation_profile -> {
                moveToFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true



            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        moveToFragment(HomeFragment())

    }

    private fun moveToFragment (fragment: Fragment){
        val fragmentTrans= supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.Frame_container, fragment)
        fragmentTrans.commit()
    }
}