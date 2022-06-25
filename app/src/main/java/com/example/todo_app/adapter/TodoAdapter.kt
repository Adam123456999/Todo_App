package com.example.todo_app.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.R
import com.example.todo_app.todoList
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
  class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
    return TodoViewHolder(view)
  }

  override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
    holder.itemView.check_box_todo_item.text = todoList[position]

    holder.itemView.check_box_todo_item.setOnClickListener {
      if (holder.itemView.check_box_todo_item.isChecked) {
        holder.itemView.check_box_todo_item.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
      } else {
        holder.itemView.check_box_todo_item.paintFlags = Paint.ANTI_ALIAS_FLAG
      }
    }
  }

  override fun getItemCount(): Int = todoList.size

  fun addTodo(todo: String) {
    todoList.add(todo)
    notifyDataSetChanged()
  }
}