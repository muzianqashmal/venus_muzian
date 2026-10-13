
package com.example.venus_muzian.pertemuan_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.venus_muzian.databinding.FragmentDuaBinding

class DuaFragment : Fragment() {

    private var _binding: FragmentDuaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDuaBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvJudulDua.text = "FRAGMENT DUA"
        binding.tvIsiDua.text =
            "Ini adalah halaman Fragment Dua"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
