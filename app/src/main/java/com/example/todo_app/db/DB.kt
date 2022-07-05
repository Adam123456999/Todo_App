package com.example.todo_app.db

import android.content.Context
import androidx.room.Room
import com.example.todo_app.db.repository.RoomGroupRepository
import com.example.todo_app.db.repository.RoomTodoRepository
import com.example.todo_app.model.GroupModel

object DB {
  lateinit var groupRepository: RoomGroupRepository
  lateinit var todoRepository: RoomTodoRepository
  private var _database: AppDatabase ?= null
  private val database get() = _database!!

  fun initDatabase(context: Context) {
    getInstance(context)
    groupRepository = RoomGroupRepository(database.getGroupDao())
  }

  private fun getInstance(context: Context): AppDatabase {
    return if (_database == null) {
      _database = Room.databaseBuilder(context, AppDatabase::class.java, "db").allowMainThreadQueries().build()
      database
    } else {
      database
    }
  }

  fun getAllGroups(): List<GroupModel> = groupRepository.getAllGroups()
  fun addGroup(groupModel: GroupModel) = groupRepository.insertGroup(groupModel)
  fun deleteGroup(groupModel: GroupModel) = groupRepository.deleteGroup(groupModel)
}