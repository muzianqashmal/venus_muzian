package com.example.venus_muzian.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.venus_muzian.R
import com.example.venus_muzian.Message.tutorial.TutorialMessageActivity
import com.example.venus_muzian.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Andi Pratama", "Halo, apakah produk ini masih tersedia?", "https://picsum.photos/seed/user1/200/200"),
        MessageModel("Siti Aminah", "Terima kasih banyak atas bantuannya ya!", "https://picsum.photos/seed/user2/200/200"),
        MessageModel("Budi Santoso", "Pesanan saya sudah dikirim belum ya?", "https://picsum.photos/seed/user3/200/200"),
        MessageModel("Dewi Lestari", "Baik, saya akan segera transfer pembayarannya.", "https://picsum.photos/seed/user4/200/200"),
        MessageModel("Rizki Ramadhan", "Diskon untuk pembelian grosir berapa persen?", "https://picsum.photos/seed/user5/200/200"),
        MessageModel("Siti Nurhaliza", "Barangnya sudah sampai dengan selamat, bagus banget!", "https://picsum.photos/seed/user6/200/200"),
        MessageModel("Ahmad Fauzi", "Mohon info resi pengirimannya kak.", "https://picsum.photos/seed/user7/200/200"),
        MessageModel("Rina Melati", "Apakah ada garansi untuk produk elektronik ini?", "https://picsum.photos/seed/user8/200/200")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        setHasOptionsMenu(true)

        // Menampilkan dialog sambutan selamat datang
        AlertDialog.Builder(requireContext())
            .setTitle("Selamat Datang")
            .setMessage("Selamat datang di Fitur Pesan! Nikmati kemudahan komunikasi dan interaksi langsung.")
            .setPositiveButton("OK", null)
            .show()

        val adapter = MessageAdapter(messageList) { selectedMessage ->
            Toast.makeText(requireContext(), "Pesan dari ${selectedMessage.senderName}", Toast.LENGTH_SHORT).show()
        }

        binding.rvMessages.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
