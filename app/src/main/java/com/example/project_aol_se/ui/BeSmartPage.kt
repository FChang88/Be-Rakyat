package com.example.project_aol_se.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_aol_se.R
import com.example.project_aol_se.data.Message
import com.example.project_aol_se.databinding.FragmentBeSmartBinding
import com.example.project_aol_se.utils.BotResponse
import com.example.project_aol_se.utils.Constants.RECEIVE_ID
import com.example.project_aol_se.utils.Constants.SEND_ID
import com.example.project_aol_se.utils.MessagingAdapter
import com.example.project_aol_se.utils.Time
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class BeSmartPage : Fragment() {
    private var _binding : FragmentBeSmartBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MessagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBeSmartBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<View>(R.id.tombolCartHover).visibility = View.GONE
        requireActivity().findViewById<View>(R.id.tombolTanyaHover).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.GONE
        requireActivity().findViewById<TextView>(R.id.Judul).text = "Be:Smart"

        recyclerView()

        clickEvents()

        binding.dateHeader.text = Time.getDateNow()

        customMessage("Halo, User! Apa yang dapat saya bantu?")
        return view
    }

    private fun clickEvents(){
        binding.btnSend.setOnClickListener {
            sendMessage()
        }

        binding.etMessage.setOnClickListener{
            GlobalScope.launch {
                delay(100)
                withContext(Dispatchers.Main){
                    binding.rvMessages.scrollToPosition(adapter.itemCount-1)
                }
            }
        }
    }

    private fun recyclerView(){
        adapter = MessagingAdapter()
        binding.rvMessages.adapter = adapter
        binding.rvMessages.layoutManager = LinearLayoutManager(requireContext().applicationContext)
    }

    private fun sendMessage() {
        val message = binding.etMessage.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
//            messagesList.add(Message(message, SEND_ID, timeStamp))
            binding.etMessage.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String){
        val timestamp = Time.timeStamp()

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val response = BotResponse.basicResponse(message)

                adapter.insertMessage(Message(response, RECEIVE_ID, timestamp))
                binding.rvMessages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch{
            delay(1000)
            withContext(Dispatchers.Main){
                binding.rvMessages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    private fun customMessage(message: String){
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val timestamp = Time.timeStamp()
                adapter.insertMessage(Message(message, RECEIVE_ID, timestamp))
                binding.rvMessages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

}