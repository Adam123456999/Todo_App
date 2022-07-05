package com.example.todo_app.db.repository

import com.example.todo_app.model.GroupModel

interface GroupRepository {

  fun getAllGroups(): List<GroupModel>
  fun insertGroup(groupModel: GroupModel)
  fun deleteGroup(groupModel: GroupModel)
}