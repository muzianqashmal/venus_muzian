package com.example.venus_muzian.Message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.venus_muzian.databinding.ItemMessageBinding

class MessageAdapter(
    private val messageList: List<MessageModel>,
    private val onItemClick: (MessageModel) -> Unit
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = messageList[position]
        with(holder.binding) {
            tvSenderName.text = item.senderName
            tvMessageText.text = item.messageText

            Glide.with(holder.itemView.context)
                .load(item.avatarUrl)
                .circleCrop()
                .into(imgAvatar)

            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int = messageList.size
}
