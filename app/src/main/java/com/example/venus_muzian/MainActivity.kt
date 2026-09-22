package com.example.venus_muzian

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.venus_muzian.pertemuan_4.FourthActivity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnToFourth = findViewById<Button>(R.id.btnToFourth)

        btnToFourth.setOnClickListener {

            val intent = Intent(
                this,
                FourthActivity::class.java
            )

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }
    }
}