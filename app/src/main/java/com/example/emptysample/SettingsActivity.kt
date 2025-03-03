package com.example.emptysample

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class SettingsActivity : Activity() {

    private lateinit var chargingLimitSeekBar: SeekBar
    private lateinit var chargingLimitValue: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val signOutButton = findViewById<Button>(R.id.sign_out_button)
        val backButton = findViewById<ImageButton>(R.id.back_button)
        val aboutthedev = findViewById<TextView>(R.id.aboutthedev)
        val manage_apps_button =findViewById<Button>(R.id.manage_apps_button)
        val terms_of_service = findViewById<TextView>(R.id.terms_of_service)
        val privacy_policy = findViewById<TextView>(R.id.privacy_policy)
        val change_password_button = findViewById<Button>(R.id.change_password_button)
        chargingLimitSeekBar = findViewById(R.id.charging_limit_seekbar)
        chargingLimitValue = findViewById(R.id.charging_limit_value)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)

        // Retrieve the saved charging limit (default: 85)
        val savedLimit = sharedPreferences.getInt("charging_limit", 85)
        chargingLimitSeekBar.progress = savedLimit
        chargingLimitValue.text = "$savedLimit%"

        // Handle SeekBar changes
        chargingLimitSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                chargingLimitValue.text = "$progress%"
                // Save the new value
                sharedPreferences.edit().putInt("charging_limit", progress).apply()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Not needed
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Not needed
            }
        })

        signOutButton.setOnClickListener {
            Log.e("Sample Project", "Button is clicked!")
            val intent = Intent(this, LogoutActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this,DashboardActivity::class.java)
            startActivity(intent)
        }

        aboutthedev.setOnClickListener {
            val intent = Intent(this, DevpageActivity::class.java)
            startActivity(intent)
        }

        manage_apps_button.setOnClickListener {
            Toast.makeText(this,"Manage Apps: Feature Coming Soon!",Toast.LENGTH_LONG).show()
        }

        change_password_button.setOnClickListener {
            Toast.makeText(this,"Change Password: Feature Coming Soon!",Toast.LENGTH_LONG).show()
        }

        terms_of_service.setOnClickListener {
            Toast.makeText(this,"Terms of Service Coming Soon!",Toast.LENGTH_LONG).show()
        }

        privacy_policy.setOnClickListener {
            Toast.makeText(this,"Privacy Policy Coming Soon!",Toast.LENGTH_LONG).show()
        }
    }
}
