
package com.example.venus_muzian

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.venus_muzian.Home.HomeFragment
import com.example.venus_muzian.Message.MessageFragment
import com.example.venus_muzian.More.MoreFragment
import com.example.venus_muzian.databinding.ActivityMainBinding
import com.example.venus_muzian.pertemuan_4.FourthActivity
import com.example.venus_muzian.pertemuan_5.FifthActivity
import com.example.venus_muzian.pertemuan_6.SixthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.message -> {
                    replaceFragment(MessageFragment())
                    true
                }

                R.id.more -> {
                    replaceFragment(MoreFragment())
                    true
                }

                else -> false
            }
        }

        binding.bottomNavView.selectedItemId = R.id.home
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
