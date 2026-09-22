package com.example.venus_muzian.pertemuan_4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.example.venus_muzian.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age", 0)

        binding.tvName.text = "Nama: $name"
        binding.tvFrom.text = "Dari: $from"

        Log.e(
            "Data Intent",
            "Nama: $name, Usia: $age, Asal: $from"
        )

        Log.e(
            "LifeCycle",
            "onCreate: FourthActivity dibuat pertama kali"
        )

        // Tombol Kembali
        binding.btnKembali.setOnClickListener {
            finish()
        }

        // Tombol Snackbar
        binding.btnShowSnackbar.setOnClickListener {

            Snackbar.make(
                binding.root,
                "Ini adalah Snackbar",
                Snackbar.LENGTH_SHORT
            )
                .setAction("Tutup") {
                    Log.e(
                        "Info Snackbar",
                        "Snackbar ditutup"
                    )
                }
                .show()
        }

        // Tombol AlertDialog
        binding.btnShowAlertDialog.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()

                    Log.e(
                        "Info Dialog",
                        "Anda memilih Ya!"
                    )
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()

                    Log.e(
                        "Info Dialog",
                        "Anda memilih Tidak!"
                    )
                }
                .show()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.e(
            "LifeCycle",
            "onStart: FourthActivity terlihat di layar"
        )
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e(
            "LifeCycle",
            "onDestroy: FourthActivity dihapus dari stack"
        )
    }
}