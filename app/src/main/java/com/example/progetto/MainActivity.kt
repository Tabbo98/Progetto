package com.example.progetto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.progetto.databinding.ActivityMainBinding
import androidx.core.view.GravityCompat
import com.example.progetto.databinding.NavHeaderBinding
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigationView =binding.navView

        navigationView.setNavigationItemSelectedListener{ menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
                }
                R.id.nav_vol_map -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, VolumeFragment()).commit()
                }
                R.id.nav_wiFi_map -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, WiFiLTEFragment()).commit()
                }
                R.id.nav_measurements -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MeasurementsFragment()).commit()
                }
                R.id.nav_settings -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SettingsFragment()).commit()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (System.currentTimeMillis() - backPressedTime > 2000) {
                Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
                backPressedTime = System.currentTimeMillis()
            } else {
                super.onBackPressed()
            }
        }
    }
}