package com.example.emptysample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class DashboardActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val settings_button = findViewById<ImageButton>(R.id.settings_button)
        val manage_apps_dashboard_button = findViewById<Button>(R.id.manage_apps_dashboard_button)
        val battery_report_button = findViewById<Button>(R.id.battery_report_button)
        val profile_button = findViewById<ImageButton>(R.id.profile_button)

        settings_button.setOnClickListener {
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }
        manage_apps_dashboard_button.setOnClickListener {
            Toast.makeText(this,"Manage Apps: Feature coming soon!.", Toast.LENGTH_LONG).show()
        }
        battery_report_button.setOnClickListener {
            Toast.makeText(this,"View Report: Feature coming soon!.", Toast.LENGTH_LONG).show()
        }
        profile_button.setOnClickListener {
            val intent = Intent(this,UserprofileActivity::class.java)
            startActivity(intent)
        }
    }
}