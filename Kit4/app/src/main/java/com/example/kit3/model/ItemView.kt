package com.example.kit3

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "history_table")
data class ItemView(@PrimaryKey(autoGenerate = true) val id: Int?,
                    @ColumnInfo(name = "Data 1") val num1: String,
                    @ColumnInfo(name = "Data 2") val num2: String,
                    @ColumnInfo(name = "Operation") val operation: String,
                    @ColumnInfo(name = "Result") val res: String): Parcelable