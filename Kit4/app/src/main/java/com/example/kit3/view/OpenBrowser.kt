package com.example.kit3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OpenBrowser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_browser)

        val btn_open = findViewById<Button>(R.id.btn_opBrow)
        val linkView = findViewById<TextView>(R.id.link)

        btn_open.setOnClickListener {
            val textLink = linkView.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(textLink))
            startActivity(intent)
        }

    }
}