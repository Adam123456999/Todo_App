package com.example.todo_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.GroupListener
import com.example.todo_app.R
import com.example.todo_app.databinding.GroupItemBinding
import com.example.todo_app.model.GroupModel

class GroupAdapter(private val listener: GroupListener) : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {

  private var groupList = emptyList<GroupModel>()

  class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = GroupItemBinding.bind(view)

    fun bind(group: GroupModel, listener: GroupListener) = with(binding) {
//      tvAmountGroupItem.text = if (group.todos.size != 0) group.todos.size.toString() else ""
      tvTitleGroupItem.text = group.title
      root.setOnClickListener {
        listener.onClick(group)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.group_item, parent, false)
    return GroupViewHolder(view)
  }

  override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
    holder.bind(groupList[position], listener)
  }

  override fun getItemCount(): Int = groupList.size

  fun setList(list: List<GroupModel>) {
    groupList = list
    notifyDataSetChanged()
  }

}