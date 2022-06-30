package com.example.todo_app.model

data class GroupModel(
  val name: String,
  val todos: ArrayList<TodoModel> = arrayListOf()
)
