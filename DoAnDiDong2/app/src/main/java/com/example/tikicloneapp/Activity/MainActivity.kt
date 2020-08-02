package com.example.tikicloneapp.Activity

import Fragment.HomeFragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.tikicloneapp.Fragment.*
import com.example.tikicloneapp.R
import kotlinx.android.synthetic.main.activity_dangnhap_dangky.*
import kotlinx.android.synthetic.main.activity_main.*
import com.example.tikicloneapp.Fragment.PageAdapter as PageAdapter1


class MainActivity : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter= PageAdapter1(fm = supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        loadFragment(HomeFragment())


        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> {
                    val fragment=HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    val fragment=DashboardFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    val fragment=SearchFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    val fragment=NotificationsFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    val fragment=ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }


    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}