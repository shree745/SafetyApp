package com.example.myfamily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottombar = findViewById<BottomNavigationView>(R.id.botbar)

        bottombar.setOnItemSelectedListener {menuItem->

            if(menuItem.itemId == R.id.guard_icon) {
                inflateFragment(GuardFragment.newInstance())
            }
            else if(menuItem.itemId == R.id.home_icon){
                inflateFragment(HomeFragment.newInstance())
            }

            // inflate is used because here we are using fragment, intent is used when we are opening new activity

            true
        }
    }

    private fun inflateFragment(newInstance: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()


    }
}