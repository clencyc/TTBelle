package com.example.mylistview.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userdata")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
)