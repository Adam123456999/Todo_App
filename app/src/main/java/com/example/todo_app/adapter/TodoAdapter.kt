package com.example.todo_app.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.R
import com.example.todo_app.TodoListener
import com.example.todo_app.databinding.TodoItemBinding
import com.example.todo_app.model.GroupModel
import com.example.todo_app.model.TodoModel

class TodoAdapter(
  private val group: GroupModel,
  private val listener: TodoListener
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

  private var todoList = emptyList<TodoModel>()

  class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = TodoItemBinding.bind(view)

    fun bind(todo: TodoModel, listener: TodoListener) = with(binding) {
      checkBoxTodoItem.text = todo.title
      checkBoxTodoItem.setOnClickListener {
        if (checkBoxTodoItem.isChecked) {
          checkBoxTodoItem.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        } else {
          checkBoxTodoItem.paintFlags = Paint.ANTI_ALIAS_FLAG
        }
        listener.onClick(todo)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
    return TodoViewHolder(view)
  }

  override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
    holder.bind(todoList[position], listener)
  }

  override fun getItemCount(): Int = todoList.size

  fun setList(list: List<TodoModel>) {
    todoList = list
    notifyDataSetChanged()
  }
}