package com.example.tikicloneapp.Fragment


import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) : Fragment {
        when (position) {
            1 -> {return dangnhapFragment()}
            2 -> {return dangkyFragment()}
            else -> {return dangnhapFragment()}
        }
    }

    override fun getCount(): Int {
        return 2
    }

}

