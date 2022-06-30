package com.example.todo_app

import com.example.todo_app.models.GroupModel
import com.example.todo_app.models.TodoModel

interface GroupListener {
  fun onClick(group: GroupModel)
}

interface TodoListener {
  fun onClick(todo: TodoModel)
}