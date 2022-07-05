package com.example.todo_app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_app.db.dao.GroupDao
import com.example.todo_app.db.dao.TodoDao
import com.example.todo_app.model.GroupModel
import com.example.todo_app.model.TodoModel

@Database(
  entities = [GroupModel::class, TodoModel::class],
  version = 1,
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun getGroupDao(): GroupDao
  abstract fun getTodoDao(): TodoDao
}