package com.example.venus_muzian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        lifecycleScope.launch {

            // Tampilkan splash selama 2 detik
            delay(2000)

            // Ambil SharedPreferences
            val sharedPref = getSharedPreferences(
                "user_pref",
                MODE_PRIVATE
            )

            // Cek status login
            val isLogin = sharedPref.getBoolean(
                "isLogin",
                false
            )

            if (isLogin) {

                // Jika sudah login → MainActivity
                val intent = Intent(
                    this@SplashScreenActivity,
                    MainActivity::class.java
                )

                startActivity(intent)

            } else {

                // Jika belum login → AuthActivity
                val intent = Intent(
                    this@SplashScreenActivity,
                    AuthActivity::class.java
                )

                startActivity(intent)
            }

            // Tutup SplashScreen
            finish()
        }
    }
}