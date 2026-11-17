package com.example.venus_muzian.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.venus_muzian.AuthActivity
import com.example.venus_muzian.Home.photo.PhotoAdapter
import com.example.venus_muzian.Home.pertemuan_10.TenthActivity
import com.example.venus_muzian.data.api.CatFactApiClient
import com.example.venus_muzian.data.api.PhotoApiClient
import com.example.venus_muzian.databinding.FragmentHomeBinding
import com.example.venus_muzian.pertemuan_4.FourthActivity
import com.example.venus_muzian.pertemuan_5.FifthActivity
import com.example.venus_muzian.pertemuan_6.SixthActivity
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        // Tombol Pertemuan 10
        binding.btnPertemuan10.setOnClickListener {
            startActivity(
                Intent(requireContext(), TenthActivity::class.java)
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

        // Load Cat Fact API
        loadCatFact()

        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }

        // Load Photo API (Picsum)
        loadPhoto()
    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                if (_binding != null) {
                    binding.tvCatFact.text = "\"${response.fact}\""
                }
            } catch (e: Exception) {
                if (_binding != null) {
                    binding.tvCatFact.text = "Gagal mengambil fakta kucing."
                }
            }
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                if (_binding != null) {
                    val adapter = PhotoAdapter(photos)
                    binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())
                    binding.rvGallery.adapter = adapter
                }
            } catch (e: Exception) {
                if (_binding != null) {
                    Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
