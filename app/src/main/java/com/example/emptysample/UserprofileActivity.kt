package com.example.emptysample

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class UserprofileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userprofile)

        val devback_button =findViewById<ImageButton>(R.id.devback_button)
        val updateprofile_button = findViewById<Button>(R.id.updateprofile_button)

        devback_button.setOnClickListener {
            finish()
        }
        updateprofile_button.setOnClickListener {
            Toast.makeText(this,"Update Profile: Feature Coming Soon!",Toast.LENGTH_LONG).show()
        }
    }
}