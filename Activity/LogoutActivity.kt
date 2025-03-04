package com.example.emptysample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LogoutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        val signout_button = findViewById<Button>(R.id.signout_button)
        val cancel_button = findViewById<Button>(R.id.cancel_button)
        val tvEmail = findViewById<TextView>(R.id.emailTextView)

        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("loggedInUser", "")
        val email = sharedPreferences.getString("email_$username", "No email found")

        tvEmail.text = email

        signout_button.setOnClickListener{
            Toast.makeText(this,"Signing Out...",Toast.LENGTH_LONG).show()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        cancel_button.setOnClickListener {
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}