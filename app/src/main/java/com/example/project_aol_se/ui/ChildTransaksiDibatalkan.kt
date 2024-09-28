package com.example.project_aol_se.ui

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentChildTransaksiDibatalkanBinding

class ChildTransaksiDibatalkan : Fragment() {
    private var _binding: FragmentChildTransaksiDibatalkanBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChildTransaksiDibatalkanBinding.inflate(inflater, container, false)
        val view = binding.root

        val Span = SpannableString("Kembali ke katalog Be:Lanja")
        Span.setSpan(ForegroundColorSpan(Color.rgb(87, 8, 255)), Span.length-8, Span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.textView55.text = Span

        binding.textView55.setOnClickListener {
            //getParentFragmentManager().popBackStackImmediate()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.containerFragment,homePage())?.commit()
        }

        return view
    }
}