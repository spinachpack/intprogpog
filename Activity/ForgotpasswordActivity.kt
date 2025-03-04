package com.example.emptysample

import android.app.Activity
import android.content.Context
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
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        forgot_backbutton.setOnClickListener {
            finish()
        }

        forgot_button.setOnClickListener {
            val username = username_forgot.text.toString().trim()

            if (username.isEmpty()) {
                username_forgot.error = "Username or Email is required!"
                return@setOnClickListener
            }

            // Check if the username exists
            if (sharedPreferences.contains("username_$username")) {
                val tempPassword = "Temp1234" // In a real app, generate a secure random password
                val editor = sharedPreferences.edit()
                editor.putString("password_$username", tempPassword) // Update password
                editor.apply()

                Toast.makeText(
                    this,
                    "Your temporary password is: $tempPassword. Please log in and change it.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(this, "Account not found!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
