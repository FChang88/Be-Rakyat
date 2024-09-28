package com.example.project_aol_se.ui

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentPermintaanProdukPageBinding
import com.example.project_aol_se.utils.DatePickerFragment
import com.github.dhaval2404.imagepicker.ImagePicker

class PermintaanProdukPage : Fragment() {

    private var _binding: FragmentPermintaanProdukPageBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var imgProfile : ImageView? = null
    private var daySelected : Int? = 30
    private var monthSelected : Int? = 11 - 1
    private var yearSelected : Int? = 2024

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!

                var mProfileUri = fileUri
                imgProfile?.setImageURI(fileUri)
                binding.button5.visibility = View.GONE
                binding.textView84.visibility = View.GONE

                binding.textView83.text = "Sample foto produk"
                imgProfile!!.visibility = View.VISIBLE
                binding.textView85.visibility = View.VISIBLE
                binding.button6.visibility = View.VISIBLE
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireActivity(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireActivity(), "Penggantian Foto Gagal", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPermintaanProdukPageBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.GONE
        requireActivity().findViewById<TextView>(R.id.Judul).text = "Be:Rakyat"

        binding.backLogo.setOnClickListener {
            getParentFragmentManager().popBackStackImmediate()
//            activity?.supportFragmentManager?.beginTransaction()
//                ?.replace(R.id.containerFragment,homePage())?.commit()

        }

        var teksMerah1 = SpannableString(binding.textView80.getText())
        teksMerah1.setSpan(ForegroundColorSpan(Color.rgb(255,0,0)), teksMerah1.length-1, teksMerah1.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textView80.text = teksMerah1

        var teksMerah2 = SpannableString(binding.textView79.getText())
        teksMerah2.setSpan(ForegroundColorSpan(Color.rgb(255,0,0)), teksMerah2.length-1, teksMerah2.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textView79.text = teksMerah2

        var teksMerah3 = SpannableString(binding.textView81.getText())
        teksMerah3.setSpan(ForegroundColorSpan(Color.rgb(255,0,0)), teksMerah3.length-1, teksMerah3.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textView81.text = teksMerah3

        var teksMerah4 = SpannableString(binding.textView82.getText())
        teksMerah4.setSpan(ForegroundColorSpan(Color.rgb(255,0,0)), teksMerah4.length-1, teksMerah4.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textView82.text = teksMerah4

        var teksMerah5 = SpannableString(binding.textView83.getText())
        teksMerah5.setSpan(ForegroundColorSpan(Color.rgb(255,0,0)), teksMerah5.length-1, teksMerah5.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textView83.text = teksMerah5

        imgProfile = binding.imageView41

        binding.button5.setOnClickListener{
            ImagePicker.with(this)
                .cropSquare()	//Crop square image, its same as crop(1f, 1f)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }
        }

        binding.apply {
            editTextText5.setOnClickListener {
                val datePickerFragment = DatePickerFragment(daySelected,monthSelected,yearSelected)
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        daySelected = bundle.getString("SELECTED_DAY")?.toInt()
                        monthSelected = bundle.getString("SELECTED_MONTH")?.toInt()!!.minus(1)
                        yearSelected = bundle.getString("SELECTED_YEAR")?.toInt()

                        editTextText5.text = date
                    }
                }

                // show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }

            imageView43.setOnClickListener {
                val datePickerFragment = DatePickerFragment(daySelected,monthSelected,yearSelected)
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        daySelected = bundle.getString("SELECTED_DAY")?.toInt()
                        monthSelected = bundle.getString("SELECTED_MONTH")?.toInt()!!.minus(1)
                        yearSelected = bundle.getString("SELECTED_YEAR")?.toInt()

                        editTextText5.text = date
                    }
                }

                // show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }
        }

        return view
    }
}