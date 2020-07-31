package com.example.tikicloneapp

//import android.support.design.widget.BottomNavigationView
//import androidx.core.app.Fragment
//import android.support.v7.app.AppCompatActivity
import Fragment.HomeFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tikicloneapp.Fragment.DashboardFragment
import com.example.tikicloneapp.Fragment.NotificationsFragment
import com.example.tikicloneapp.Fragment.ProfileFragment
import com.example.tikicloneapp.Fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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


    /// mới thêm
    override fun onResume() {
        super.onResume()
// Write a message to the database
        val database = Firebase.database
//        val myRef = database.getReference("message")
//        myRef.setValue("Hello, World!")
    }

}