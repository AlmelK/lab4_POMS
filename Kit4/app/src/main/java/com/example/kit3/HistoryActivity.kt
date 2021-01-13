package com.example.kit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private var history: java.util.ArrayList<ItemView>? = java.util.ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val intent = intent

        history = intent.extras?.getParcelableArrayList<ItemView>(MainActivity.HISTORY_KEY)

            Log.d("SIZE", history?.size.toString())


        val recyclerView = findViewById<RecyclerView>(R.id.history_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(history)
    }
}