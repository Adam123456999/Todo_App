package com.example.todo_app.screen.group

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todo_app.db.DB
import com.example.todo_app.model.GroupModel


class GroupViewModel(application: Application) : AndroidViewModel(application) {

  private val context = application

  fun initDatabase() = DB.initDatabase(context)

  fun getAllGroups(): List<GroupModel> = DB.getAllGroups()

  fun addGroup(groupModel: GroupModel): List<GroupModel> {
    DB.addGroup(groupModel)
    return getAllGroups()
  }
  fun deleteGroup(groupModel: GroupModel): List<GroupModel> {
    DB.deleteGroup(groupModel)
    return getAllGroups()
  }
}