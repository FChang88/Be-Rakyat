package com.example.project_aol_se.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.project_aol_se.utils.DatePickerFragment
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.FragmentProfilePageBinding
import com.github.dhaval2404.imagepicker.ImagePicker


class profilePage : Fragment() {
    private var _binding: FragmentProfilePageBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private var imgProfile : ImageView? = null
    private var birthDateDay : Int? = 31
    private var birthDateMonth : Int? = 12
    private var birthDateYear : Int? = 1999


    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!

                var mProfileUri = fileUri
                imgProfile?.setImageURI(fileUri)
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireActivity(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireActivity(), "Penggantian Foto Gagal", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilePageBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().findViewById<View>(R.id.tombolCartHover).visibility = View.GONE
        requireActivity().findViewById<View>(R.id.tombolTanyaHover).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.imageView8).visibility = View.GONE
        requireActivity().findViewById<TextView>(R.id.Judul).text = "Profile"

        imgProfile = binding.profilePicture

        binding.areaGantiFoto.setOnClickListener{
            ImagePicker.with(this)
                .compress(1024)         //Final image size will be less than 1 MB(Optional)
                .cropSquare()	//Crop square image, its same as crop(1f, 1f)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }
        }

        val textName = binding.textView12
        val textBio = binding.textView16

        disableEditText(textName)
        disableEditText(textBio)

        var BioFlagEdit = false
        var NameFlagEdit = false

        binding.imageView16.setOnClickListener {
            if(BioFlagEdit == false){
                enableEditText(textBio)
                textBio.requestFocus()
                val imgr = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imgr.showSoftInput(textBio, InputMethodManager.SHOW_IMPLICIT)
                BioFlagEdit = true
                binding.imageView16.setImageResource(R.drawable.edit_clicked_logo)
            }else if(BioFlagEdit == true){
                disableEditText(textBio)
                binding.imageView16.setImageResource(R.drawable.edit_logo)
                BioFlagEdit = false
            }
        }

        binding.imageView12.setOnClickListener {
            if(NameFlagEdit == false){
                enableEditText(textName)
                textName.requestFocus()
                val imgr = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imgr.showSoftInput(textName, InputMethodManager.SHOW_IMPLICIT)
                NameFlagEdit = true
                binding.imageView12.setImageResource(R.drawable.edit_clicked_logo)
            }else if(NameFlagEdit == true){
                disableEditText(textName)
                binding.imageView12.setImageResource(R.drawable.edit_logo)
                NameFlagEdit = false
            }
        }

        binding.apply {
            imageView17.setOnClickListener {
                val datePickerFragment = DatePickerFragment(birthDateDay,birthDateMonth,birthDateYear)
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        birthDateDay = bundle.getString("SELECTED_DAY")?.toInt()
                        birthDateMonth = bundle.getString("SELECTED_MONTH")?.toInt()!!.minus(1)
                        birthDateYear = bundle.getString("SELECTED_YEAR")?.toInt()

                        textView25.text = date
                    }
                }

                // show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }

            textView25.setOnClickListener {
                val datePickerFragment = DatePickerFragment(birthDateDay,birthDateMonth,birthDateYear)
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        birthDateDay = bundle.getString("SELECTED_DAY")?.toInt()
                        birthDateMonth = bundle.getString("SELECTED_MONTH")?.toInt()!!.minus(1)
                        birthDateYear = bundle.getString("SELECTED_YEAR")?.toInt()

                        textView25.text = date
                    }
                }

                // show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }
        }

        binding.textView28.setOnClickListener {
            getParentFragmentManager().beginTransaction().replace(R.id.containerFragment, TransaksiPage()).addToBackStack("").commit()
        }

        binding.textView30.setOnClickListener {
            val Intent = Intent(activity, LandingPage::class.java)
            startActivity(Intent)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}