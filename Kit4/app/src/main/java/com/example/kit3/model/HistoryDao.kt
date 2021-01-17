package com.example.kit3.model

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kit3.ItemView

@Dao
public interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public fun addHistoryItem(historyItem: ItemView)

    @Query("SELECT*from history_table")
    public fun getAll(): List<ItemView>

    @Query("DELETE from history_table")
    public fun deleteAll()
}