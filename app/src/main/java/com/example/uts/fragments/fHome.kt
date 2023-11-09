package com.example.uts.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts.AddTransactionActivity
import com.example.uts.InfoActivity
import com.example.uts.LoginActivity
import com.example.uts.MainViewModel
import com.example.uts.MainViewModel.Companion.getInstance
import com.example.uts.R
//import com.example.uts.ARG_PARAM1
//import com.example.uts.ARG_PARAM2
import com.example.uts.Transaction
import com.example.uts.TransactionAdapter
import com.example.uts.databinding.FragmentFHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [fHome.newInstance] factory method to
 * create an instance of this fragment.
 */

class fHome : Fragment() {
    // TODO: Rename and change types of parameters
    private var transactions: ArrayList<Transaction> = arrayListOf()
    private lateinit var transactionAdapter : TransactionAdapter
    private lateinit var layoutManager : LinearLayoutManager
    private var _binding: FragmentFHomeBinding? = null
    private val viewModel = getInstance()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val result = arguments?.getString(USER)
//        binding.tvMain.text = result
        binding.logout.setOnClickListener {
            val moveToLoginActivity = Intent(requireContext(), LoginActivity::class.java)
            startActivity(moveToLoginActivity)
        }

        binding.info.setOnClickListener {
            val moveToInfoActivity = Intent(requireContext(), InfoActivity::class.java)
            startActivity(moveToInfoActivity)
        }

        binding.addTransaction.setOnClickListener {
            if (binding.categoryInput.selectedItem != null) {
                val selectedCategory = binding.categoryInput.selectedItem.toString()
                val amountText = binding.amountInput.text.toString()
                if (amountText.isNotEmpty()) { // Check if the input is not empty
                    val amount = amountText.toDouble()

                    when (selectedCategory) {
                        "Income" -> {
                            val currentIncome = binding.income.text.toString().toDouble()
                            val newIncome = currentIncome + amount
                            viewModel.setterIncome(newIncome)
                            Log.d("fHome", "onViewCreated: ${viewModel.getterIncome()}")
                            binding.income.text = "%.2f".format(newIncome)
                        }

                        "Outcome" -> {
                            val currentOutcome = binding.outcome.text.toString().toDouble()
                            val newOutcome = currentOutcome + amount
                            viewModel.currentOutcome = newOutcome
                            Log.d("fHome", "onViewCreated: ${viewModel.currentOutcome}")
                            binding.outcome.text = "%.2f".format(newOutcome)
                        }
                    }

                    // Update the balance independently without updating the dashboard
                    val currentIncome = binding.income.text.toString().toDouble()
                    val currentOutcome = binding.outcome.text.toString().toDouble()
                    val currentBalance = binding.balance.text.toString().toDouble()
                    val newBalance = currentIncome - currentOutcome
                    binding.balance.text = "%.2f".format(newBalance)

                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//    companion object{
//        const val USER = "user"
//    }
}