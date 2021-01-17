package com.example.kit3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kit3.R
import com.example.kit3.viewmodel.HistoryFacad

class DBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_b)

        val showDpBtn = findViewById<Button>(R.id.show_base)
        val clearDB = findViewById<Button>(R.id.clear_base)
        val clearScreen = findViewById<Button>(R.id.clear_screen)

        showDpBtn.setOnClickListener {
            val dbContent = findViewById<TextView>(R.id.db_content)
            dbContent.setText(HistoryFacad.getAllAsString(this))
        }

        clearDB.setOnClickListener {
            HistoryFacad.delete(this)
        }

        clearScreen.setOnClickListener {
            val dbContent = findViewById<TextView>(R.id.db_content)
            dbContent.setText("")
        }
    }
}