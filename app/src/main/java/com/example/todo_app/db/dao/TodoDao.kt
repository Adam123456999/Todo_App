package com.example.todo_app.db.dao

import androidx.room.*
import com.example.todo_app.model.TodoModel

@Dao
interface TodoDao {

  @Query("select * from todo_table where group_id = :groupId")
  fun getById(groupId: Int): List<TodoModel>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(todoModel: TodoModel)

  @Delete
  fun delete(todoModel: TodoModel)
}