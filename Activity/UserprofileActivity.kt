package com.example.emptysample

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class UserprofileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userprofile)

        val devback_button =findViewById<ImageButton>(R.id.devback_button)
        val updateprofile_button = findViewById<Button>(R.id.updateprofile_button)

        val prof_user = findViewById<TextView>(R.id.prof_user)
        val prof_name = findViewById<TextView>(R.id.prof_name)

        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        // Get the logged-in username
        val username = sharedPreferences.getString("loggedInUser", "No email found") ?: "No email found"
        val fullName = sharedPreferences.getString("fullName_$username", "No Name") ?: "No Name"

        // Update UI
        prof_user.text = "Email/Username: $username"
        prof_name.text = "Name: $fullName"


        devback_button.setOnClickListener {
            finish()
        }
        updateprofile_button.setOnClickListener {
            Toast.makeText(this,"Update Profile: Feature Coming Soon!",Toast.LENGTH_LONG).show()
        }
    }
}