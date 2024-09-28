package com.example.project_aol_se.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project_aol_se.R

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)
        val linkToLoginText = findViewById<TextView>(R.id.textView22)

        val Span = SpannableString("Sudah punya akun? Login di sini.")
        Span.setSpan(ForegroundColorSpan(Color.rgb(87, 8, 255)), 18, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        Span.setSpan(StyleSpan(Typeface.BOLD), 18, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        Span.setSpan(UnderlineSpan(), 18, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        linkToLoginText.text = Span

        linkToLoginText.setOnClickListener {
            val Intent = Intent(this, LoginPage::class.java)
            startActivity(Intent)
        }

        val nama_text = findViewById<TextView>(R.id.textView17)
        val email_text = findViewById<TextView>(R.id.textView19)
        val pass_text = findViewById<TextView>(R.id.textView21)
        val confpass_text = findViewById<TextView>(R.id.textView23)

        val Span_nama = SpannableString("Nama*")
        val Span_email = SpannableString("Email*")
        val Span_pass = SpannableString("Password*")
        val Span_confpass = SpannableString("Konfirmasi Password*")

        Span_nama.setSpan(ForegroundColorSpan(Color.RED), Span_nama.length-1, Span_nama.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        Span_email.setSpan(ForegroundColorSpan(Color.RED), Span_email.length-1, Span_email.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        Span_pass.setSpan(ForegroundColorSpan(Color.RED), Span_pass.length-1, Span_pass.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        Span_confpass.setSpan(ForegroundColorSpan(Color.RED), Span_confpass.length-1, Span_confpass.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        nama_text.text = Span_nama
        email_text.text = Span_email
        pass_text.text = Span_pass
        confpass_text.text = Span_confpass

        val tombolDaftar = findViewById<Button>(R.id.buttonDaftar)

        tombolDaftar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        }

        val tombolMasukGmail = findViewById<ImageView>(R.id.logoGoogle)

        tombolMasukGmail.setOnClickListener {
            val Intent = Intent(this, SignInGmaill::class.java)
            startActivity(Intent)
        }

    }
}