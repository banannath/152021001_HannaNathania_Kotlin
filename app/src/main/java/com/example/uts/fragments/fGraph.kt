package com.example.uts.fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.uts.MainViewModel
import com.example.uts.databinding.FragmentFGraphBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class fGraph : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel = MainViewModel.getInstance()
    private var _binding: FragmentFGraphBinding? = null
    private val binding get() = _binding!!

    // Your onCreateView and other functions here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFGraphBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add your chart initialization and button click handling code here

        // For example, initialize the chart and handle button click here
        val pieChart: PieChart = binding.pieChart
        val incomeEditText: EditText = binding.income
        val outcomeEditText: EditText = binding.outcome
        val okButton: Button = binding.btnOk

        // Your chart initialization and button click handling code

        okButton.setOnClickListener {
            val pieChart: PieChart = binding.pieChart
            val income = incomeEditText.text.toString().toFloat()
            val outcome = outcomeEditText.text.toString().toFloat()

            val entiers = ArrayList<PieEntry>()
            entiers.add(PieEntry(income, "Income"))
            entiers.add(PieEntry(outcome, "Outcome"))

            val pieDataSet = PieDataSet(entiers, "Expenses")
            pieDataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

            val pieData = PieData(pieDataSet)
            pieChart.data = pieData

            pieChart.description.isEnabled = false
            pieChart.animateY(1000)
            pieChart.invalidate()
        }
    }
}
