package com.example.kit3.viewmodel

import android.content.Context
import com.example.kit3.ItemView
import com.example.kit3.model.AppDatabase
import java.lang.StringBuilder

public class HistoryFacad {
    companion object{
        fun addItem(context: Context, newItem: ItemView){
            AppDatabase.getDataBase(context)?.historyDao()!!.addHistoryItem(newItem)
        }

        fun getAllAsString(context: Context): String{
            val history: List<ItemView> =  AppDatabase.getDataBase(context)?.historyDao()!!.getAll()
            var all_data: String = ""
            for(itemView: ItemView in history){
                all_data += "${itemView.num1} \t ${itemView.num2} \t ${itemView.operation} \t ${itemView.res} \n"
            }
            return all_data
        }

        fun getAllAsList(context: Context): List<ItemView>{
            return AppDatabase.getDataBase(context)?.historyDao()!!.getAll()
        }

        fun delete(context: Context){
            AppDatabase.getDataBase(context)?.historyDao()!!.deleteAll()
        }
    }
}