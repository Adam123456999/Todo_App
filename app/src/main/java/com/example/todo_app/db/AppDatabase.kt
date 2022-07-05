package com.example.todo_app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_app.db.dao.GroupDao
import com.example.todo_app.model.GroupModel

@Database(entities = [GroupModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun getGroupDao(): GroupDao
}