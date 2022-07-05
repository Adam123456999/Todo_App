package com.example.todo_app.screen.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo_app.GroupListener
import com.example.todo_app.R
import com.example.todo_app.adapter.GroupAdapter
import com.example.todo_app.databinding.FragmentGroupBinding
import com.example.todo_app.db.AppDatabase
import com.example.todo_app.model.GroupModel
import com.example.todo_app.screen.todo.TodoFragment


class GroupFragment : Fragment(), GroupListener {

  private var _binding: FragmentGroupBinding? = null
  private val binding get() = _binding!!
  private lateinit var viewModel: GroupViewModel
  private lateinit var recyclerView: RecyclerView
  private lateinit var adapter: GroupAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    _binding = FragmentGroupBinding.inflate(inflater, container, false)

    init()

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)



    binding.btnFragmentGroupAddTodo.setOnClickListener {
      if (binding.etFragmentGroupInputText.text.isNotEmpty()) {
        adapter.setList(viewModel.addGroup(GroupModel(
          title = binding.etFragmentGroupInputText.text.toString()
        )))
        binding.etFragmentGroupInputText.text.clear()
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun onClick(group: GroupModel) {
    parentFragmentManager
      .beginTransaction()
      .addToBackStack(null)
      .replace(R.id.fragment_container, TodoFragment(group))
      .commit()
  }

  private fun init() {
    viewModel = ViewModelProvider(this).get(GroupViewModel::class.java)
    viewModel.initDatabase()

    adapter = GroupAdapter(this)
    recyclerView = binding.rvFragmentGroupTodoList
    recyclerView.adapter = adapter

    adapter.setList(viewModel.getAllGroups())
  }

}