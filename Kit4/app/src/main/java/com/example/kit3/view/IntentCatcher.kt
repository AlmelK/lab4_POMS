package com.example.kit3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView

class IntentCatcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_catcher)

        val textView = findViewById<TextView>(R.id.textView)
        val intent: Intent = getIntent()
        val shLink: String? = intent.getStringExtra(Intent.EXTRA_TEXT)
        textView.setText(shLink)

    }
}

