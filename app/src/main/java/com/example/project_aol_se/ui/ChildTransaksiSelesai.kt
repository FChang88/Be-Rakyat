package com.example.project_aol_se.ui

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentChildTransaksiSelesaiBinding


class ChildTransaksiSelesai : Fragment() {

    private var _binding: FragmentChildTransaksiSelesaiBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChildTransaksiSelesaiBinding.inflate(inflater, container, false)
        val view = binding.root

        val Span = SpannableString("Jika ada keluhan atas pesananmu mohon klik link ini")
        Span.setSpan(ForegroundColorSpan(Color.rgb(87, 8, 255)), (Span.length - 8), Span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val teksRekap = SpannableString("Rekap Pengiriman")
        teksRekap.setSpan(UnderlineSpan(), 0, teksRekap.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.textView55.text = Span
        binding.textView56.text = teksRekap

        return view
    }

}