package com.example.kit3

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.kit3.viewmodel.HistoryFacad
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_number.*


class NumberFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_number, container, false)
        val txt: TextView = view.findViewById(R.id.totalView)
        val textNum1: TextView = view.findViewById(R.id.num1)
        val textNum2: TextView = view.findViewById(R.id.num2)
        val btnSum: Button = view.findViewById(R.id.total_btn)

        btnSum.setOnClickListener {
            txt.setText(add(textNum1.text.toString(), textNum2.text.toString()))
        }
        return view
    }

    fun add(n1: String, n2: String): String {
        if (n1.isEmpty() || n2.isEmpty()) {
            val dur = Toast.LENGTH_SHORT
            val toast = Toast.makeText(context, R.string.warningNum, dur)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()

            val er: String = ":("
            return er
        } else {
            val total: Double = n1.toDouble() + n2.toDouble()
            addToHistory(n1, n2, total.toString())
            return (total.toString())
        }
    }

    fun addToHistory(n1: String, n2: String, res: String) {
        val parent = activity as MainActivity?
        parent?.addItem(ItemView(null, n1, n2, "Addition", res))
    }
}