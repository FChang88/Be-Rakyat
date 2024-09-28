package com.example.project_aol_se.utils

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import java.text.SimpleDateFormat
import java.util.*

class DatePickerFragment(val birthDateDay: Int?, val birthDateMonth: Int?, val birthDateYear: Int?) : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private val calendar = Calendar.getInstance()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // default date
        val year = birthDateYear
        val month = birthDateMonth
        val day = birthDateDay

        // return new DatePickerDialog instance
        return DatePickerDialog(requireActivity(), this, year!!, month!!, day!!)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        val selectedDate = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(calendar.time)
        val selectedDay = SimpleDateFormat("dd", Locale.ENGLISH).format(calendar.time)
        val selectedMonth = SimpleDateFormat("MM", Locale.ENGLISH).format(calendar.time)
        val selectedYear = SimpleDateFormat("yyyy", Locale.ENGLISH).format(calendar.time)

        val selectedDateBundle = Bundle()
        selectedDateBundle.putString("SELECTED_DATE", selectedDate)
        selectedDateBundle.putString("SELECTED_DAY", selectedDay)
        selectedDateBundle.putString("SELECTED_MONTH", selectedMonth)
        selectedDateBundle.putString("SELECTED_YEAR", selectedYear)

        setFragmentResult("REQUEST_KEY", selectedDateBundle)
    }
}