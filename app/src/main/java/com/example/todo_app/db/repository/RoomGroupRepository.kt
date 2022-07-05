package com.example.todo_app.db.repository

import com.example.todo_app.db.dao.GroupDao
import com.example.todo_app.model.GroupModel

class RoomGroupRepository(
  private val groupDao: GroupDao
) : GroupRepository {

  override fun getAllGroups(): List<GroupModel> = groupDao.getAllGroups()

  override fun insertGroup(groupModel: GroupModel) {
    groupDao.insert(groupModel)
  }

  override fun deleteGroup(groupModel: GroupModel) {
    groupDao.delete(groupModel)
  }

}