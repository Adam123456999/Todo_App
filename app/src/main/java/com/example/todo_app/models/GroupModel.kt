package com.example.todo_app.models

data class GroupModel(
  val name: String,
  val todos: ArrayList<TodoModel> = arrayListOf()
)
