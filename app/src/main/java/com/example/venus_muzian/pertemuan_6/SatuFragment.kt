
package com.example.venus_muzian.pertemuan_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.venus_muzian.databinding.FragmentSatuBinding

class SatuFragment : Fragment() {

    private var _binding: FragmentSatuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatuBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvJudulSatu.text = "FRAGMENT SATU"
        binding.tvIsiSatu.text =
            "Selamat datang di Fragment Satu"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
