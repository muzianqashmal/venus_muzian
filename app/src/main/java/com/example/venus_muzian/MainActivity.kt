
package com.example.venus_muzian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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

        // Tombol Pertemuan 4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }

        // Tombol Pertemuan 5
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }

        // Tombol Pertemuan 6 - Fragment
        binding.btnPertemuan6.setOnClickListener {
            val intent = Intent(this, SixthActivity::class.java)
            startActivity(intent)
        }

        // Tombol Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setNegativeButton("Tidak", null)
                .setPositiveButton("Ya") { dialog, _ ->

                    // Ambil SharedPreferences
                    val sharedPref = getSharedPreferences(
                        "user_pref",
                        MODE_PRIVATE
                    )

                    // Hapus data login
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    // Kembali ke halaman Login
                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    finish()

                    dialog.dismiss()
                }
                .show()
        }
    }
}
