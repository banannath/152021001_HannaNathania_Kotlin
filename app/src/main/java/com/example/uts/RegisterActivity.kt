package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var fullname = findViewById<EditText>(R.id.edt_fname)
        var username = findViewById<EditText>(R.id.edt_uname)
        val pass = findViewById<EditText>(R.id.edt_pass)
        val email = findViewById<EditText>(R.id.edt_email)

        val register = findViewById<Button>(R.id.register)
        val back_to_login = findViewById<Button>(R.id.back_login)


        register.setOnClickListener {
            if (username.text.toString() != "" && pass.text.toString() != "" && email.text.toString() != "" && fullname.text.toString() != ""){
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", username.text.toString())
                intent.putExtra("pass", pass.text.toString()) // Pass the username as an extra
                startActivity(intent)
            } else if (username.text.toString() == "" || pass.text.toString() == "" || email.text.toString() == "" || fullname.text.toString() == ""){
                MaterialAlertDialogBuilder(this)
                    .setTitle("Field tidak terisi lengkap")
                    .setMessage("Harap isi field dengan lengkap untuk melanjutkan")
                    .setNeutralButton("OK") { dialog, which -> }.show()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Field tidak diisi")
                    .setMessage("Harap isi field dengan lengkap untuk melanjutkan")
                    .setNeutralButton("OK") { dialog, which -> }.show()
            }
        }

        back_to_login.setOnClickListener {
            var moveToLoginActivity = Intent(this,LoginActivity::class.java)
            startActivity(moveToLoginActivity)
        }
    }
}