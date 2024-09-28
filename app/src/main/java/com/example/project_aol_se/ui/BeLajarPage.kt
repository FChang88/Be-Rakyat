package com.example.project_aol_se.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentBeLajarBinding


class BeLajarPage : Fragment() {

    private var _binding: FragmentBeLajarBinding? = null
    // This property is only valid between onCreateView and onDestroyView.

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBeLajarBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<View>(R.id.tombolCartHover).visibility = View.GONE
        requireActivity().findViewById<View>(R.id.tombolTanyaHover).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.GONE
        requireActivity().findViewById<TextView>(R.id.Judul).text = "Be:Lajar"

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}