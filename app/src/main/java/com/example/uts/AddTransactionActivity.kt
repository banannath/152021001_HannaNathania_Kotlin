package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Button
import android.widget.ImageButton

class AddTransactionActivity : AppCompatActivity() {
    private var pilihan = 0
    private val transactions = arrayListOf<Transaction>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        val btn_transaction = findViewById<Button>(R.id.addTransaction)
        val btn_back = findViewById<ImageButton>(R.id.back)
        val labelLayout = findViewById<TextInputLayout>(R.id.labelLayout)
        val amountLayout = findViewById<TextInputLayout>(R.id.amountLayout)

        val labelInput = findViewById<TextInputEditText>(R.id.labelInput)
        val amountInput = findViewById<TextInputEditText>(R.id.amountInput)
        val categorySpinner = findViewById<Spinner>(R.id.categoryInput)

        // Create an ArrayAdapter for the spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.category_transaction,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        btn_transaction.setOnClickListener {
            val label = labelInput.text.toString()
            val amountText = amountInput.text.toString()

            if (label.isEmpty()) {
                labelLayout.error = "Please fill in the label"
            } else if (amountText.isEmpty()) {
                amountLayout.error = "Please fill in the amount"
            } else {
                labelLayout.error = null
                amountLayout.error = null

                val amount = amountText.toDouble()
                val result = if (pilihan == 0) amount else -amount

                val newTransaction = Transaction(label, result)
                transactions.add(newTransaction)

                if (transactions.size > 0) {
                    Toast.makeText(this, "Transaction added successfully!", Toast.LENGTH_LONG).show()
                }
            }
        }

        btn_back.setOnClickListener {
            val moveToMainActivity = Intent(this, MainActivity::class.java)
            startActivity(moveToMainActivity)
        }

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                pilihan = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }
    }
}
