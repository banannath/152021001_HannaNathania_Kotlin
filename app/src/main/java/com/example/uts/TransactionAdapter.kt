package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(val transactionsList: ArrayList<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val label: TextView = v.findViewById(R.id.label)
        val amount: TextView = v.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.transaction_layout, parent, false)
        return TransactionViewHolder(v)
    }


    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction: Transaction = transactionsList[position]
        val context = holder.amount.context

        val amountText = when {
            transaction.amount >= 0 -> "+ $%.2f".format(Math.abs(transaction.amount))
            else -> "- $%.2f".format(Math.abs(transaction.amount))
        }

        holder.amount.text = amountText

        val colorRes = if (transaction.amount >= 0) R.color.md_theme_light_primaryContainer else R.color.md_theme_light_error
        holder.amount.setTextColor(ContextCompat.getColor(context, colorRes))

        holder.label.text = transaction.label
    }


    override fun getItemCount(): Int {
        return transactionsList.size
    }
}