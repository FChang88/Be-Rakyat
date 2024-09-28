package com.example.project_aol_se.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project_aol_se.databinding.FragmentChildTransaksiBerlangsungBinding

class ChildTransaksiBerlangsung : Fragment() {

    private var _binding: FragmentChildTransaksiBerlangsungBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChildTransaksiBerlangsungBinding.inflate(inflater, container, false)
        val view = binding.root

        val Span = SpannableString("Estimasi waktu pengiriman :")
        Span.setSpan(UnderlineSpan(), 0, Span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.textView43.text = Span

        return view
    }

}