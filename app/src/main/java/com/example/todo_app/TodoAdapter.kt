package com.example.todo_app

import android.graphics.Paint
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
    holder.itemView.check_box_group_item.text = todoList[position]

    holder.itemView.check_box_group_item.setOnClickListener {
      if (holder.itemView.check_box_group_item.isChecked) {
        holder.itemView.check_box_group_item.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
      } else {
        holder.itemView.check_box_group_item.paintFlags = Paint.ANTI_ALIAS_FLAG
      }
    }
  }

  override fun getItemCount(): Int = todoList.size

  fun addTodo(todo: String) {
    todoList.add(todo)
    notifyDataSetChanged()
  }
}