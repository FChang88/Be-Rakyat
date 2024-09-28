package com.example.project_aol_se.ui

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.project_aol_se.R
import com.example.project_aol_se.utils.ViewPagerAdapter
import com.example.project_aol_se.databinding.FragmentHomePageBinding


class homePage : Fragment() {
    private var titleList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()
    private var created : Boolean = false

    private var _binding: FragmentHomePageBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<View>(R.id.tombolCartHover).visibility = View.GONE
        requireActivity().findViewById<View>(R.id.tombolTanyaHover).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.Judul).text = "Be:Rakyat"

        val initialDate = Calendar.getInstance()
        val timeOfDay: Int = initialDate.get(Calendar.HOUR_OF_DAY)

        if (timeOfDay >= 0 && timeOfDay < 12) {
            binding.textView7.text = "Selamat Pagi, User!"
        } else if (timeOfDay >= 12 && timeOfDay < 15) {
            binding.textView7.text = "Selamat Siang, User!"
        } else if (timeOfDay >= 15 && timeOfDay < 18) {
            binding.textView7.text = "Selamat Sore, User!"
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            binding.textView7.text = "Selamat Malam, User!"
        }

        if(created == false){
            postToList()
        }


        val view_pager2 = binding.viewPager2

        view_pager2.adapter = ViewPagerAdapter(titleList,imageList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = binding.indicator
        indicator.setViewPager(view_pager2)

        binding.constraintLayout3.setOnClickListener {
            //getParentFragmentManager().popBackStackImmediate()
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,PermintaanProdukPage())?.addToBackStack("")
                ?.commit()
        }

        binding.kategori4.setOnClickListener {
            //getParentFragmentManager().popBackStackImmediate()
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,PermintaanProdukPage())?.addToBackStack("")
                ?.commit()

        }

        binding.imageView6.setOnClickListener {
            //getParentFragmentManager().popBackStackImmediate()
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,BeCart())?.addToBackStack("")
                ?.commit()

        }

        binding.cardView2.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,AllCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.kategori3.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,AllCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.itemGabah.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,ProdukDetailPage())?.addToBackStack("")?.commit()
        }

        binding.itemPesti.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,ProdukDetailPage())?.addToBackStack("")?.commit()
        }

        binding.itemPupuk.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,ProdukDetailPage())?.addToBackStack("")?.commit()
        }

        binding.itemGabah2.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,ProdukDetailPage())?.addToBackStack("")?.commit()
        }

        binding.cardView3.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.kategori5.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.cardView5.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.kategori2.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.cardView6.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        binding.kategori6.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.containerFragment,SpecificCategoryPage())?.addToBackStack("")
                ?.commit()
        }

        created = true
        return view
    }

    private fun addToList(title: String, image: Int){
        titleList.add(title)
        imageList.add(image)
    }

    private fun postToList(){
        addToList("Produk Baru! BerasKita", R.drawable.beras_carousell)
        addToList("Breaking News! Cuaca Semakin Membaik!", R.drawable.sawah_carousel)
        addToList("Lima Manfaat Gula Untuk Kesehatan", R.drawable.gula_carousel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}