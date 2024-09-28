package com.example.project_aol_se.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.project_aol_se.R

class SignInGmaill : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_gmaill)

        val tombolLanjut = findViewById<Button>(R.id.button4)

        tombolLanjut.setOnClickListener {
            continueToPassword()
        }

    }

    private fun continueToPassword(){
        val inputBoxContainer_Email = findViewById<EditText>(R.id.editTextEmail)
        val userEmail = inputBoxContainer_Email.text.toString()

        val intent = Intent(this, SignInGmailPass::class.java).also {
            it.putExtra("EXTRA_MESSAGE", userEmail)
            startActivity(it)
        }

    }
}