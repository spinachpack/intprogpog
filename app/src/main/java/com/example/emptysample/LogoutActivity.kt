package com.example.emptysample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LogoutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        val signout_button = findViewById<Button>(R.id.signout_button)
        val cancel_button = findViewById<Button>(R.id.cancel_button)

        signout_button.setOnClickListener{
            Toast.makeText(this,"You have logged out.",Toast.LENGTH_LONG).show()
        }

        cancel_button.setOnClickListener {
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}