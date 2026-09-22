package com.example.venus_muzian.pertemuan_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.venus_muzian.databinding.ActivityThirdBinding

class ThirdActivity : Activity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKirim.setOnClickListener {

            val noTujuan = binding.inputNoTujuan.text.toString()

            val intent = Intent(
                this,
                ThirdResultActivity::class.java
            )

            startActivity(intent)
        }
    }
}