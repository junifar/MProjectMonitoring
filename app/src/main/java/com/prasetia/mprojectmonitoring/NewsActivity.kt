package com.prasetia.mprojectmonitoring

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity(){

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                changeFragment(HomeFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                changeFragment(NewsFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
//                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if(savedInstanceState == null){
            changeFragment(HomeFragment.newInstance())
        }


    }

    private fun changeFragment(f:Fragment, cleanStack: Boolean= false){
        val ft = fragmentManager.beginTransaction()
        if(cleanStack){
            clearBackStack()
        }
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out)
        ft.replace(R.id.news_content, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}
