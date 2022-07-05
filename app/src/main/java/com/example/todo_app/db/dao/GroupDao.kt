package com.example.todo_app.db.dao

import androidx.room.*
import com.example.todo_app.model.GroupModel

@Dao
interface GroupDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(groupModel: GroupModel)

  @Delete
  fun delete(groupModel: GroupModel)

  @Query("select * from group_table")
  fun getAllGroups(): List<GroupModel>
}