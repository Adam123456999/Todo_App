package com.example.todo_app.screen.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.TodoListener
import com.example.todo_app.adapter.TodoAdapter
import com.example.todo_app.databinding.FragmentTodoBinding
import com.example.todo_app.model.GroupModel
import com.example.todo_app.model.TodoModel


class TodoFragment(
  private val groupModel: GroupModel
) : Fragment(), TodoListener {

  private var _binding: FragmentTodoBinding? = null
  private val binding get() = _binding!!
  private lateinit var recyclerView: RecyclerView
  private lateinit var adapter: TodoAdapter
  private lateinit var viewModel: TodoViewModel


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    _binding = FragmentTodoBinding.inflate(inflater, container, false)

    init()

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.btnAddTodoFragmentTodo.setOnClickListener {
      if (binding.inputTextFragmentTodo.text.isNotEmpty()) {
        adapter.setList(viewModel.addTodo(TodoModel(
          groupId = groupModel.id,
          title = binding.inputTextFragmentTodo.text.toString()
        )))
        binding.inputTextFragmentTodo.text.clear()
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun onClick(todo: TodoModel) {

  }

  private fun init() {
    viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
    adapter = TodoAdapter(groupModel, this)
    recyclerView = binding.rvFragmentTodoList
    recyclerView.adapter = adapter

    adapter.setList(viewModel.getTodosByGroupId(groupModel.id))
  }
}