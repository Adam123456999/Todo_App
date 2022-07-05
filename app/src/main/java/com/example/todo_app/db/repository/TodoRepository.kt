package com.example.todo_app.db.repository

import com.example.todo_app.model.TodoModel


interface TodoRepository {

  fun getTodosById(groupId: Int): List<TodoModel>
  fun insertTodo(todoModel: TodoModel)
  fun deleteTodo(todoModel: TodoModel)
}