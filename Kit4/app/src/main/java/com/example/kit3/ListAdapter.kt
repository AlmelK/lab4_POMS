package com.example.kit3

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.lang.StringBuilder
import java.util.zip.Inflater

class ListAdapter(private val history: java.util.ArrayList<ItemView>?)
    : RecyclerView.Adapter<ListAdapter.ItemViewHolder>(){

    override fun getItemCount(): Int = history?.size ?: 0

    class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var forInf: TextView = itemView.findViewById(R.id.info1)
        var forOper: TextView = itemView.findViewById(R.id.info2)
        var forRes: TextView = itemView.findViewById(R.id.info3)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.forInf.setText(history?.get(position)?.num1+ "   " + history?.get(position)?.num2)
        holder.forOper.setText(history?.get(position)?.operation)
        holder.forRes.setText(history?.get(position)?.res)
    }

}