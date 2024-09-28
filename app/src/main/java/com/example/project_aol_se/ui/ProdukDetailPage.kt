package com.example.project_aol_se.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentProdukDetailPageBinding
import com.example.project_aol_se.utils.ViewPagerAdapterProduk

class ProdukDetailPage : Fragment() {

    private var _binding: FragmentProdukDetailPageBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var imageList = mutableListOf<Int>()
    private var created :Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProdukDetailPageBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.backLogo.setOnClickListener {
            getParentFragmentManager().popBackStackImmediate()
        }

        binding.imageView6.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,BeCart())?.addToBackStack("")
                ?.commit()
        }

        requireActivity().findViewById<View>(R.id.tombolCartHover).visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.tombolTanyaHover).visibility = View.VISIBLE
        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.GONE
        requireActivity().findViewById<TextView>(R.id.Judul).text = "Be:Rakyat"

        if(!created){
            postToList()
            created = true
        }

        val view_pager2 = binding.viewPager69

        view_pager2.adapter = ViewPagerAdapterProduk(imageList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = binding.indicator69
        indicator.setViewPager(view_pager2)

        requireActivity().findViewById<View>(R.id.tombolCartHover).setOnClickListener{
            openDialog()
        }

        return view
    }

    private fun openDialog(){
        val dialogFragment : DialogFragment = DialogAddCartFragment()
        dialogFragment.show(requireActivity().supportFragmentManager, "example")
    }

    private fun addToList(image: Int){
        imageList.add(image)
    }

    private fun postToList(){
        addToList(R.drawable.gabah_img)
        addToList(R.drawable.gabah_img)
        addToList(R.drawable.gabah_img)
        addToList(R.drawable.gabah_img)
    }
}