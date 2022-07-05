package com.example.todo_app.screen.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todo_app.db.DB
import com.example.todo_app.model.TodoModel

class TodoViewModel(application: Application) : AndroidViewModel(application) {

  fun getTodosByGroupId(groupId: Int): List<TodoModel> = DB.getTodosByGroupId(groupId)

  fun addTodo(todoModel: TodoModel): List<TodoModel> {
    DB.addTodo(todoModel)
    return getTodosByGroupId(todoModel.groupId)
  }
  fun deleteGroup(todoModel: TodoModel): List<TodoModel> {
    DB.deleteTodo(todoModel)
    return getTodosByGroupId(todoModel.groupId)
  }
}