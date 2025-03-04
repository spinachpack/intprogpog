package com.example.emptysample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class ChangePasswordActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepassword)

        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val loggedInUsername = sharedPreferences.getString("loggedInUser", null)

        val change_currentp = findViewById<EditText>(R.id.change_currentp)
        val change_new = findViewById<EditText>(R.id.change_new)
        val change_button = findViewById<Button>(R.id.change_button)
        val change_back = findViewById<ImageButton>(R.id.change_back)

        change_back.setOnClickListener {
            finish()
        }

        change_button.setOnClickListener {
            val current = change_currentp.text.toString().trim()
            val newPass = change_new.text.toString().trim()

            if (loggedInUsername == null) {
                Toast.makeText(this, "No user logged in", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val storedPassword = sharedPreferences.getString("password_$loggedInUsername", null)

            if (storedPassword == null || storedPassword != current) {
                Toast.makeText(this, "Incorrect current password", Toast.LENGTH_SHORT).show()
            } else if (current == newPass) {
                Toast.makeText(this, "New password must be different", Toast.LENGTH_SHORT).show()
            } else if (newPass.length < 8) {
                Toast.makeText(this, "New password must be at least 8 characters", Toast.LENGTH_SHORT).show()
            } else {
                val editor = sharedPreferences.edit()
                editor.putString("password_$loggedInUsername", newPass) // Update password only
                editor.apply()

                Toast.makeText(this, "Password changed successfully", Toast.LENGTH_SHORT).show()

                // Redirect to login
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}
