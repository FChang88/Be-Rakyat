package com.example.project_aol_se.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object Time {

    fun timeStamp() : String{
        val timeStamp = Timestamp(System.currentTimeMillis())
        val sdf = SimpleDateFormat("HH:mm")
        val time = sdf.format(Date(timeStamp.time))

        return time.toString()
    }

    fun getDateNow() :String{
        val tanggal = Calendar.getInstance()
        val day = tanggal.get(Calendar.DAY_OF_WEEK)
        val date = tanggal.get(Calendar.DAY_OF_MONTH)
        val month = tanggal.get(Calendar.MONTH) + 1
        val year = tanggal.get(Calendar.YEAR)

        val hari = when(day){
            Calendar.SUNDAY -> "Minggu"
            Calendar.MONDAY -> "Senin"
            Calendar.TUESDAY -> "Selasa"
            Calendar.WEDNESDAY -> "Rabu"
            Calendar.THURSDAY -> "Kamis"
            Calendar.FRIDAY -> "Jum'at"
            Calendar.SATURDAY -> "Sabtu"
            
            else -> "Error"
        }

        val bulan = when(month){
            1 -> "Januari"
            2 -> "Februari"
            3 -> "Maret"
            4 -> "April"
            5 -> "Mei"
            6 -> "Juni"
            7 -> "Juli"
            8 -> "Agustus"
            9 -> "September"
            10 -> "Oktober"
            11 -> "November"
            12 -> "Desember"

            else -> "Error"
        }
        
        return "$hari, $date $bulan $year"
    }
}