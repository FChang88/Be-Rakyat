package com.example.project_aol_se.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentAllCategoryPageBinding

class AllCategoryPage : Fragment(), OnClickListener {

    private var _binding: FragmentAllCategoryPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAllCategoryPageBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<TextView>(R.id.Judul).text = "Be:Rakyat"

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

        binding.moreGabah.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.morePesti.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.morePupuk.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        // Gabah
        binding.constraintLayout15.setOnClickListener(this)
        binding.constraintLayout16.setOnClickListener(this)
        binding.constraintLayout17.setOnClickListener(this)
        binding.constraintLayout19.setOnClickListener(this)
        binding.constraintBawah1.setOnClickListener(this)
        binding.constraintBawah2.setOnClickListener(this)
        binding.constraintLayout20.setOnClickListener(this)

        // Pestisida
        binding.constraintLayout15pesti.setOnClickListener(this)
        binding.constraintLayout16pesti.setOnClickListener(this)
        binding.constraintLayout17pesti.setOnClickListener(this)
        binding.constraintLayout19pesti.setOnClickListener(this)
        binding.constraintBawahPesti1.setOnClickListener(this)
        binding.constraintBawahPesti2.setOnClickListener(this)
        binding.constraintLayout20pesti.setOnClickListener(this)

        // Pupuk
        binding.constraintLayout15pupuk.setOnClickListener(this)
        binding.constraintLayout16pupuk.setOnClickListener(this)
        binding.constraintLayout17pupuk.setOnClickListener(this)
        binding.constraintLayout19pupuk.setOnClickListener(this)
        binding.constraintBawahPupuk1.setOnClickListener(this)
        binding.constraintBawahPupuk2.setOnClickListener(this)
        binding.constraintBawahPupuk2.setOnClickListener(this)
        binding.constraintLayout20pupuk.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ?.replace(R.id.containerFragment,ProdukDetailPage())?.addToBackStack("")
            ?.commit()
    }

}