package com.example.project_aol_se.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentBeCartBinding

class BeCart : Fragment() {

    private var _binding: FragmentBeCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBeCartBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<TextView>(R.id.Judul).text = "Be:Cart"

        requireActivity().findViewById<View>(R.id.tombolCartHover).visibility = View.GONE
        requireActivity().findViewById<View>(R.id.tombolTanyaHover).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.GONE

        binding.imageView52.setOnClickListener {
            getParentFragmentManager().popBackStackImmediate()
        }

        binding.apply {
            textView101.setOnClickListener {
                binding.textView100.text = increment(binding.textView100)
            }

            textView99.setOnClickListener {
                binding.textView100.text = decrement(binding.textView100)
            }

            textView102.setOnClickListener {
                binding.textView103.text = decrement(binding.textView103)
            }

            textView107.setOnClickListener {
                binding.textView103.text = increment(binding.textView103)
            }

            textView102e.setOnClickListener {
                binding.textView103f.text = decrement(binding.textView103f)
            }

            textView107g.setOnClickListener {
                binding.textView103f.text = increment(binding.textView103f)
            }
        }


        binding.button12.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,BayarPage())?.addToBackStack("")
                ?.commit()
        }

        return view
    }

    fun increment(view: TextView): CharSequence? {
        var numberStr :String  = view.getText().toString()
        var numberInt :Int = numberStr.toInt()

        numberInt += 1
        numberStr = numberInt.toString()

        return numberStr
    }

    fun decrement(view: TextView): CharSequence? {
        var numberStr :String  = view.getText().toString()
        var numberInt :Int = numberStr.toInt()

        if(numberInt > 0){
            numberInt -= 1
        }
        numberStr = numberInt.toString()

        return numberStr
    }
}