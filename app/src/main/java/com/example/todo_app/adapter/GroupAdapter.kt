package com.example.todo_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.R
import com.example.todo_app.databinding.GroupItemBinding
import com.example.todo_app.groupList
import kotlinx.android.synthetic.main.group_item.view.*

class GroupAdapter(private val listener: Listener) : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {

  class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = GroupItemBinding.bind(view)

    fun bind(group: String, listener: Listener) = with(binding) {
      tvGroupItem.text = group
      tvGroupItem.setOnClickListener {
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

  fun addGroup(group: String) {
    groupList.add(group)
    notifyDataSetChanged()
  }

  interface Listener{
    fun onClick(group: String)
  }
}