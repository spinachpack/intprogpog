package com.example.emptysample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val et_username = findViewById<EditText>(R.id.et_username)
        val et_password = findViewById<EditText>(R.id.et_password)
        val login_button = findViewById<Button>(R.id.login_button)
        val register_button = findViewById<Button>(R.id.register_button)
        val login_backbutton = findViewById<ImageButton>(R.id.login_backbutton)
        val forgotp_textview = findViewById<TextView>(R.id.forgotp_textview)
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        login_button.setOnClickListener {
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()

            if (username.isEmpty()) {
                et_username.error = "Username is required!"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                et_password.error = "Password is required!"
                return@setOnClickListener
            }

            // Retrieve stored credentials
            val storedUsername = sharedPreferences.getString("username_$username", null)
            val storedPassword = sharedPreferences.getString("password_$username", null)

            if (storedUsername == null || storedPassword == null) {
                Toast.makeText(this, "User not found!", Toast.LENGTH_SHORT).show()
            } else if (password == storedPassword) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Incorrect password!", Toast.LENGTH_SHORT).show()
            }
        }

        register_button.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        login_backbutton.setOnClickListener {
            val intent = Intent(this,LandingpageActivity::class.java)
            startActivity(intent)
        }

        forgotp_textview.setOnClickListener {
            val intent = Intent(this,ForgotpasswordActivity::class.java)
            startActivity(intent)
        }
    }
}
