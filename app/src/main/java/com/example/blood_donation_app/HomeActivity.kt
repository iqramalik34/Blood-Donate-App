package com.example.blood_donation_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import com.example.blood_donation_app.R
import com.example.blood_donation_app.fragments.HistoryFragment
import com.example.blood_donation_app.fragments.InboxFragment
import com.example.blood_donation_app.fragments.NotificationFragment
import com.example.blood_donation_app.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

  class HomeActivity : AppCompatActivity() {
    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeFragment= HomeFragment()
        val inboxFragment= InboxFragment()
        val notificationFragment= NotificationFragment()
        val historyFragment= HistoryFragment()

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.inbox -> setCurrentFragment(inboxFragment)
                R.id.notification -> setCurrentFragment(notificationFragment)
                R.id.history -> setCurrentFragment(historyFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()

    }
}

