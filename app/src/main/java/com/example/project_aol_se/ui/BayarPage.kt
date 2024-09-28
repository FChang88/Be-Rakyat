package com.example.project_aol_se.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentBayarPageBinding

class BayarPage : Fragment() {

    private var _binding : FragmentBayarPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBayarPageBinding.inflate(inflater, container, false)
        val view = binding.root

        val textAlamat = binding.textView134
        val textDetail = binding.editTextText7

        disableEditText(textAlamat)
        disableEditText(textDetail)

        var alamatFlagEdit = false
        var detailFlagEdit = false

        binding.imageView61.setOnClickListener {
            if(alamatFlagEdit == false){
                enableEditText(textAlamat)
                textAlamat.requestFocus()
                val imgr = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imgr.showSoftInput(textAlamat, InputMethodManager.SHOW_IMPLICIT)
                alamatFlagEdit = true
                binding.imageView61.setImageResource(R.drawable.edit_clicked_logo)
            }else if(alamatFlagEdit == true){
                disableEditText(textAlamat)
                binding.imageView61.setImageResource(R.drawable.edit_logo)
                alamatFlagEdit = false
            }
        }

        binding.imageView64.setOnClickListener {
            if(detailFlagEdit == false){
                enableEditText(textDetail)
                textDetail.requestFocus()
                val imgr = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imgr.showSoftInput(textDetail, InputMethodManager.SHOW_IMPLICIT)
                detailFlagEdit = true
                binding.imageView64.setImageResource(R.drawable.edit_clicked_logo)
            }else if(detailFlagEdit == true){
                disableEditText(textDetail)
                binding.imageView64.setImageResource(R.drawable.edit_logo)
                detailFlagEdit = false
            }
        }

        return view
    }

    private fun disableEditText(editText: EditText) {
        editText.isFocusable = false
        editText.setEnabled(false)
        editText.setCursorVisible(false)
    }

    private fun enableEditText(editText: EditText) {
        editText.isFocusable = true
        editText.setEnabled(true)
        editText.setCursorVisible(true)
        editText.setFocusable(true)
        editText.setFocusableInTouchMode(true)
    }
}