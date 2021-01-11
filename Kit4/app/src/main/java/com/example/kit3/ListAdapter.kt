package com.example.kit3

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.util.zip.Inflater

class ListAdapter(private val history: java.util.ArrayList<ItemView>?)
    : RecyclerView.Adapter<ListAdapter.ItemViewHolder>(){

    override fun getItemCount(): Int = history?.size ?: 0

    class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val forDat: TextView = itemView.findViewById(R.id.info)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.forDat.setText(history?.get(position)?.num1 + " " + history?.get(position)?.num2 + " " + history?.get(position)?.operation + " "+ history?.get(position)?.res)
    }

}