package com.example.todo_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.group_item.view.*

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
  class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.group_item, parent, false)
    return TodoViewHolder(view)
  }

  override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
    holder.itemView.tv_group_item_todo_text.text = todoList[position]
  }

  override fun getItemCount(): Int = todoList.size

  fun addTodo(todo: String) {
    todoList.add(todo)
    notifyDataSetChanged()
  }
}