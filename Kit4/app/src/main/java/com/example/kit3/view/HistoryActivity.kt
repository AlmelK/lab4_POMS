package com.example.kit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kit3.viewmodel.HistoryFacad

class HistoryActivity : AppCompatActivity() {

    private lateinit var history: List<ItemView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val intent = intent

        history = HistoryFacad.getAllAsList(this)

            Log.d("SIZE", history?.size.toString())


        val recyclerView = findViewById<RecyclerView>(R.id.history_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(history)
    }
}