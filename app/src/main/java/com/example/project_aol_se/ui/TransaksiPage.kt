package com.example.project_aol_se.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentTransaksiPageBinding

class TransaksiPage() : Fragment() {

    private var _binding: FragmentTransaksiPageBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransaksiPageBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<View>(R.id.tombolCartHover).visibility = View.GONE
        requireActivity().findViewById<View>(R.id.tombolTanyaHover).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.GONE
        requireActivity().findViewById<TextView>(R.id.Judul).text = "Be:Rakyat"

        //init
        replaceFragment(ChildTransaksiBerlangsung())

        binding.backLogo.setOnClickListener {
//            getParentFragmentManager().popBackStackImmediate()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.containerFragment,homePage())?.commit()

        }

        binding.textView39.setOnClickListener {
            binding.textView41.background.setTint(Color.rgb(69,135,40))
            binding.textView41.setTextColor(Color.rgb(249,238,189))

            binding.textView42.background.setTint(Color.rgb(69,135,40))
            binding.textView42.setTextColor(Color.rgb(249,238,189))

            binding.textView39.background.setTint(Color.rgb(249,238,189))
            binding.textView39.setTextColor(Color.rgb(0,0,0))

            replaceFragment(ChildTransaksiBerlangsung_2())
        }

        binding.textView41.setOnClickListener {
            binding.textView39.background.setTint(Color.rgb(69,135,40))
            binding.textView39.setTextColor(Color.rgb(249,238,189))

            binding.textView42.background.setTint(Color.rgb(69,135,40))
            binding.textView42.setTextColor(Color.rgb(249,238,189))

            binding.textView41.background.setTint(Color.rgb(249,238,189))
            binding.textView41.setTextColor(Color.rgb(0,0,0))

            replaceFragment(ChildTransaksiSelesai())
        }

        binding.textView42.setOnClickListener {
            binding.textView39.background.setTint(Color.rgb(69,135,40))
            binding.textView39.setTextColor(Color.rgb(249,238,189))

            binding.textView41.background.setTint(Color.rgb(69,135,40))
            binding.textView41.setTextColor(Color.rgb(249,238,189))

            binding.textView42.background.setTint(Color.rgb(249,238,189))
            binding.textView42.setTextColor(Color.rgb(0,0,0))

            replaceFragment(ChildTransaksiDibatalkan())
        }


        return view
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = getChildFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.transaksiStatus, fragment)
        fragmentTransaction.commit()
    }
}