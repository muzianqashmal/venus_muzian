package com.example.venus_muzian.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.venus_muzian.AuthActivity
import com.example.venus_muzian.databinding.FragmentHomeBinding
import com.example.venus_muzian.pertemuan_4.FourthActivity
import com.example.venus_muzian.pertemuan_5.FifthActivity
import com.example.venus_muzian.pertemuan_6.SixthActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        binding.tvHome.text = "Halaman Home"

        // Tombol Pertemuan 4
        binding.btnToFourth.setOnClickListener {
            startActivity(
                Intent(requireContext(), FourthActivity::class.java)
            )
        }

        // Tombol Pertemuan 5
        binding.btnToFifth.setOnClickListener {
            startActivity(
                Intent(requireContext(), FifthActivity::class.java)
            )
        }

        // Tombol Pertemuan 6
        binding.btnPertemuan6.setOnClickListener {
            startActivity(
                Intent(requireContext(), SixthActivity::class.java)
            )
        }

        // Tombol Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah kamu yakin ingin logout?")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Ya") { _, _ ->
                    val intent = Intent(
                        requireContext(),
                        AuthActivity::class.java
                    )
                    startActivity(intent)
                    requireActivity().finish()
                }
                .show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
