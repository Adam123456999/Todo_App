package com.example.todo_app.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_table")
data class GroupModel(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,

  @ColumnInfo
  val title: String,
)