package com.example.animals

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.animals.data.AddFragment
import com.example.animals.data.AnimalsFragment

class MyAdapter(fm: FragmentManager, private var totalTabs: Int) :
     FragmentPagerAdapter(fm){

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                AddFragment()
            }
            1 -> {
                AnimalsFragment()
            }
            else -> getItem(position)
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}