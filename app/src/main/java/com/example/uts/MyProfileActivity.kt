package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView

class MyProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        var username = intent.getStringExtra("username")
        var pass = intent.getStringExtra("pass")

        val textView = findViewById<TextView>(R.id.username)
        textView.text = "Username : $username " // Display the username

        val textView2 = findViewById<TextView>(R.id.pass)
        textView2.text = "Password : $pass " // Display the username

        Log.d("tag", "onCreate: $username")
        Log.d("tag", "onCreate: $pass")

        val btn_back = findViewById<ImageButton>(R.id.btn_back)
        btn_back.setOnClickListener {
            finish()
        }

    }
}