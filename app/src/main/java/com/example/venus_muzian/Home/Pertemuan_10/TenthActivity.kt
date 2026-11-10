package com.example.venus_muzian.Home.pertemuan_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.venus_muzian.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol kembali
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Adapter ViewPager2
        val adapter = TenthTabsAdapter(this)
        binding.viewPager.adapter = adapter

        // Menghubungkan TabLayout dengan ViewPager2
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->

            when (position) {
                0 -> tab.text = "Tab A"
                1 -> tab.text = "Tab B"
                2 -> tab.text = "Produk"
            }

        }.attach()
    }
}
