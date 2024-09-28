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


class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val linkToRegisterText = findViewById<TextView>(R.id.textView22)

        val Span = SpannableString("Belum punya akun? Register di sini.")
        Span.setSpan(ForegroundColorSpan(Color.rgb(87, 8, 255)), 18, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        Span.setSpan(StyleSpan(Typeface.BOLD), 18, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        Span.setSpan(UnderlineSpan(), 18, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        linkToRegisterText.text = Span

        linkToRegisterText.setOnClickListener {
            val Intent = Intent(this, RegisterPage::class.java)
            startActivity(Intent)
        }

        val tombolMasuk = findViewById<Button>(R.id.button2)
        /*
        * algoritma untuk masuk akun
        * */
        tombolMasuk.setOnClickListener {
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