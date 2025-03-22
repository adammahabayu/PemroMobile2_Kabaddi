package com.example.kabaddi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Color(
    @PrimaryKey(autoGenerate = true) val _id: Long = 0L,
    @ColumnInfo(name = "hex_color") val hexColor: String,
    val name: String
)