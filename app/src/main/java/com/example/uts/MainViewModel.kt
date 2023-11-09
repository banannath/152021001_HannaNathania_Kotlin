package com.example.uts

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var currentIncome: Double = 0.0
//         set(value) {
//            currentIncome = value
//        }

    var currentOutcome: Double = 0.0

    companion object {
        fun getInstance() = MainViewModel()
    }

    fun setterIncome(value: Double) {
        currentIncome = value
    }

    fun getterIncome() = currentIncome
}