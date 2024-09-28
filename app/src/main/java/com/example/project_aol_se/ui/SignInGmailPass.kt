package com.example.project_aol_se.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project_aol_se.R

class SignInGmailPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_gmail_pass)

        val userGmailInput = intent.getStringExtra("EXTRA_MESSAGE")


        if(!(userGmailInput.isNullOrBlank())){
            val viewOutputGmail = findViewById<TextView>(R.id.emailInput).apply {
                text = userGmailInput
            }
        }

        val tombolMasuk = findViewById<Button>(R.id.buttonMasuk)

        tombolMasuk.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        }
        /*
        * Algoritma masuk akun gmail
        * */

    }
}