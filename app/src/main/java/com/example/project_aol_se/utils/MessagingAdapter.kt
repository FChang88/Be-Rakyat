package com.example.project_aol_se.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_aol_se.R
import com.example.project_aol_se.data.Message
import com.example.project_aol_se.utils.Constants.RECEIVE_ID
import com.example.project_aol_se.utils.Constants.SEND_ID


class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messageslist = mutableListOf<Message>()
    inner class MessageViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
//        init{
//            itemView.setOnClickListener {
//                messageslist.removeAt(adapterPosition)
//                notifyItemRemoved(adapterPosition)
//            }
//
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false))
    }

    override fun getItemCount(): Int {
        return messageslist.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val curentMessage = messageslist[position]

        when (curentMessage.id){
            SEND_ID ->{
                holder.itemView.findViewById<TextView>(R.id.tv_message).apply {
                    text = curentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<FrameLayout>(R.id.frameLayout3).visibility = View.VISIBLE
                holder.itemView.findViewById<TextView>(R.id.tv_timestamp_send).apply{
                    visibility = View.VISIBLE
                    text = Time.timeStamp()
                }

                holder.itemView.findViewById<TextView>(R.id.tv_timestamp_bot).visibility = View.GONE
                holder.itemView.findViewById<FrameLayout>(R.id.frameLayout2).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.tv_bot_message).visibility = View.GONE
            }

            RECEIVE_ID -> {
                holder.itemView.findViewById<TextView>(R.id.tv_bot_message).apply {
                    text = curentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<FrameLayout>(R.id.frameLayout2).visibility = View.VISIBLE
                holder.itemView.findViewById<TextView>(R.id.tv_timestamp_bot).apply{
                    visibility = View.VISIBLE
                    text = Time.timeStamp()
                }

                holder.itemView.findViewById<TextView>(R.id.tv_timestamp_send).visibility = View.GONE
                holder.itemView.findViewById<FrameLayout>(R.id.frameLayout3).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.tv_message).visibility = View.GONE
            }
        }
    }

    fun insertMessage(message: Message){
        this.messageslist.add(message)
        notifyItemInserted(messageslist.size)
    }
}