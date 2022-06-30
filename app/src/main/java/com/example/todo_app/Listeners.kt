package com.example.todo_app

import com.example.todo_app.model.GroupModel
import com.example.todo_app.model.TodoModel

interface GroupListener {
  fun onClick(group: GroupModel)
}

interface TodoListener {
  fun onClick(todo: TodoModel)
}