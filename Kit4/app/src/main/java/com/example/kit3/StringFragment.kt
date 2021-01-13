package com.example.kit3

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class StringFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_string, container, false)

        val gotText: TextView = view.findViewById(R.id.textSort)
        val forResult: TextView = view.findViewById(R.id.result_view)
        val btnSort: Button = view.findViewById(R.id.btn_say)

        btnSort.setOnClickListener {
            val resultText: String = sort(gotText.text.toString())
            forResult.setText(resultText)
        }
        return view
    }

    fun sort(stroke: String): String{
        if(stroke.isEmpty())
        {
            val dur = Toast.LENGTH_SHORT
            val toast = Toast.makeText(context, R.string.warningStr, dur)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()

            val res: String = ":("
            return res
        }
        val arr = stroke.toCharArray()
        val res: String = arr.sorted().joinToString("")

        addToHistory(stroke, res)

        return res
    }

    fun addToHistory(n1: String,  res: String){
        val parent = activity as MainActivity?
        parent?.addItem(ItemView(n1, "", "Sorting", res))
    }
}