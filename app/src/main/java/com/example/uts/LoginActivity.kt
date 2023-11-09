package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var username = findViewById<EditText>(R.id.edt_uname)
        val pass = findViewById<EditText>(R.id.edt_pass)

        val moveToLogin = findViewById<Button>(R.id.login)
        moveToLogin.setOnClickListener {
            if (username.text.toString() == "hanna" && pass.text.toString() == "1234"){
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", username.text.toString())
                intent.putExtra("pass", pass.text.toString())
                Toast.makeText(this,"Selamat datang, ${username.text.toString()} !",Toast.LENGTH_LONG).show()
                startActivity(intent)
            } else if (username.text.toString()!== "" && pass.text.toString() !== ""){
                MaterialAlertDialogBuilder(this)
                    .setTitle("Field belum diisi")
                    .setMessage("Harap isi field dengan lengkap untuk melanjutkan")
                    .setNeutralButton("OK") { dialog, which ->

                    }
                    .show()
            } else if (username.text.toString() == "" || pass.text.toString() == "") {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Field tidak terisi lengkap")
                    .setMessage("Harap isi field dengan lengkap untuk melanjutkan")
                    .setNeutralButton("OK") { dialog, which ->

                    }
                    .show()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Terjadi kesalahan pada username atau password")
                    .setMessage("Harap coba kembali")
                    .setNeutralButton("OK") { dialog, which ->

                    }
                    .show()
                username.text.clear()
                pass.text.clear()
            }
        }

        val moveToRegsiter = findViewById<Button>(R.id.to_register)
        moveToRegsiter.setOnClickListener {
            val moveToRegisterActivity= Intent(this, RegisterActivity::class.java)
            startActivity(moveToRegisterActivity)
        }
    }
}