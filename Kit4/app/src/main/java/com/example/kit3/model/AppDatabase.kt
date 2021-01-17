package com.example.kit3.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kit3.ItemView

@Database(entities = [ItemView::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao

    companion object{
        @Volatile
        private var instance: AppDatabase? = null
        fun getDataBase(context: Context): AppDatabase?{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "history_database").allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return instance
        }
    }
}