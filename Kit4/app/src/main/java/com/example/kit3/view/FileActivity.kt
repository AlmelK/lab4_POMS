package com.example.kit3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.kit3.R
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class FileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

        val btn_read = findViewById<Button>(R.id.btn_filecont)
        val textView = findViewById<TextView>(R.id.textView2)

        btn_read.setOnClickListener {
            textView.setText(readFromFile())
        }
    }

    fun readFromFile(): String{
        var text: String = ""
        try{
            val file = File(this.filesDir, "service_file.txt")
            text = FileInputStream(file).bufferedReader().use {
                it.readText()
            }
        }
        catch (e: IOException) {Log.d("FileTest", e.toString())}
        return text
    }
}