package com.example.emptysample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val register_button = findViewById<Button>(R.id.register_button)
        val et_firstname = findViewById<EditText>(R.id.et_firstname)
        val et_lastname = findViewById<EditText>(R.id.et_lastname)
        val et_username = findViewById<EditText>(R.id.et_username)
        val et_registerpass = findViewById<EditText>(R.id.et_registerpass)
        val register_back = findViewById<ImageButton>(R.id.register_back)
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        register_back.setOnClickListener {
            finish()
        }

        register_button.setOnClickListener {
            val firstname = et_firstname.text.toString().trim()
            val lastname = et_lastname.text.toString().trim()
            val username = et_username.text.toString().trim()
            val password = et_registerpass.text.toString().trim()

            if (firstname.isEmpty()) {
                et_firstname.error = "First name is required!"
            } else if (lastname.isEmpty()) {
                et_lastname.error = "Last name is required!"
            } else if (username.isEmpty()) {
                et_username.error = "Username is required!"
            } else if (password.isEmpty()) {
                et_registerpass.error = "Password is required!"
            } else if (password.length < 8) {
                et_registerpass.error = "Password must be at least 8 characters long"
            } else {
                // Check if username already exists
                if (sharedPreferences.contains("username_$username")) {
                    Toast.makeText(this, "Username already exists!", Toast.LENGTH_SHORT).show()
                } else {
                    // Save user data
                    val editor = sharedPreferences.edit()
                    editor.putString("fullName_$username", "$firstname $lastname")
                    editor.putString("username_$username", username)
                    editor.putString("email_$username", username) // If using actual email, change this field
                    editor.putString("password_$username", password)
                    editor.putString("loggedInUser", username) // Store the logged-in user
                    editor.apply()

                    Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        }
    }
}
