package com.example.emptysample

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast


class ForgotpasswordActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        val forgot_backbutton = findViewById<ImageButton>(R.id.forgot_backbutton)
        val username_forgot = findViewById<EditText>(R.id.username_forgot)
        val forgot_button = findViewById<Button>(R.id.forgot_button)

        forgot_backbutton.setOnClickListener {
            finish()
        }
        forgot_button.setOnClickListener {
            val username = username_forgot.text.toString().trim()

            if (username.isEmpty()) {
                username_forgot.error = "Username or Email is required!"
                return@setOnClickListener
            }
            else{
                Toast.makeText(this, "A password reset link has been sent to your email. Please check your inbox.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}