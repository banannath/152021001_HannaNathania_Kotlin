package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val btn_start = findViewById<Button>(R.id.start)
        btn_start.setOnClickListener {
            val moveToLoginActivity = Intent(this, LoginActivity::class.java)
            startActivity(moveToLoginActivity)
        }
    }
}