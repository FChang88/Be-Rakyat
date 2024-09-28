package com.example.project_aol_se.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.project_aol_se.R

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val pageHeader = findViewById<TextView>(R.id.landingPageHeader)

//      Span
        val Span = SpannableString("Selamat datang di Be:Rakyat")
        Span.setSpan(ForegroundColorSpan(Color.rgb(69, 135, 40)), 18, Span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        pageHeader.text = Span

        val tombolMasuk = findViewById<Button>(R.id.button3)
        tombolMasuk.setOnClickListener {
            val Intent = Intent(this, LoginPage::class.java)
            startActivity(Intent)
        }

        val tombolDaftar = findViewById<Button>(R.id.button)
        tombolDaftar.setOnClickListener {
            val Intent = Intent(this, RegisterPage::class.java)
            startActivity(Intent)
        }
    }

    private var back_pressed : Long = 0
    private var backToast : Toast? = null


    override fun onBackPressed() {
        if (back_pressed + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            backToast?.cancel()
            finishAffinity()
            LandingPage().finish()
            ActivityCompat.finishAffinity(this);
            System.out.close()
        }else {
            backToast = Toast.makeText(getApplicationContext(), "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT)
            val back_Toast = backToast
            back_Toast?.show()
        }
        back_pressed = System.currentTimeMillis()
    }

}