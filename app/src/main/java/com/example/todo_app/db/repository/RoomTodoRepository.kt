package com.example.todo_app.db.repository

import com.example.todo_app.db.dao.TodoDao
import com.example.todo_app.model.TodoModel

class RoomTodoRepository(
  private val todoDao: TodoDao
) : TodoRepository {

  override fun getTodosById(groupId: Int): List<TodoModel> = todoDao.getById(groupId)

  override fun insertTodo(todoModel: TodoModel) = todoDao.insert(todoModel)

  override fun deleteTodo(todoModel: TodoModel) = todoDao.delete(todoModel)
}