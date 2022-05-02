package com.restaurantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.restaurantes.fragments.*

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        val homeFragment = HomeFragment()
        val notificationsFragment = NotificationsFragment()
        val profileFragment = ProfileFragment()
        val configFragment = ConfigFragment()

        makeCurrentFragment(homeFragment)
        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.notifications -> makeCurrentFragment(notificationsFragment)
                R.id.profile -> makeCurrentFragment(profileFragment)
                R.id.config -> makeCurrentFragment(configFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}