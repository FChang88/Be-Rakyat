package com.example.project_aol_se.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentSpecificCategoryPageBinding

class SpecificCategoryPage : Fragment(), OnClickListener {

    private var _binding : FragmentSpecificCategoryPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecificCategoryPageBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<View>(R.id.tombolCartHover).visibility = View.GONE
        requireActivity().findViewById<View>(R.id.tombolTanyaHover).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.VISIBLE

        binding.imageView6.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,BeCart())?.addToBackStack("")
                ?.commit()
        }

        binding.backLogo.setOnClickListener {
            getParentFragmentManager().popBackStackImmediate()
        }

        binding.constraintLayout15.setOnClickListener(this)
        binding.constraintLayout19.setOnClickListener(this)
        binding.constraintLayout16.setOnClickListener(this)
        binding.constraintLayout17.setOnClickListener(this)
        binding.constraintLayout20.setOnClickListener(this)
        binding.constraintBawah1.setOnClickListener(this)
        binding.constraintBawah2.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ?.replace(R.id.containerFragment,ProdukDetailPage())?.addToBackStack("")
            ?.commit()
    }
}