package com.example.emptysample

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton

class DevpageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devpage)

        val devback_button = findViewById<ImageButton>(R.id.devback_button)

        devback_button.setOnClickListener {
            finish()
        }
    }
}