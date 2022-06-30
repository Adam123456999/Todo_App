package com.example.todo_app.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.GroupListener
import com.example.todo_app.R
import com.example.todo_app.adapter.GroupAdapter
import com.example.todo_app.databinding.FragmentGroupBinding
import com.example.todo_app.models.GroupModel


class GroupFragment : Fragment(), GroupListener {

  private var _binding: FragmentGroupBinding? = null
  private val binding get() = _binding!!
  private lateinit var recyclerView: RecyclerView
  private lateinit var adapter: GroupAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    _binding = FragmentGroupBinding.inflate(inflater, container, false)
    adapter = GroupAdapter(this)
    recyclerView = binding.rvFragmentGroupTodoList
    recyclerView.adapter = adapter
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.btnFragmentGroupAddTodo.setOnClickListener {
      if (binding.etFragmentGroupInputText.text.isNotEmpty()) {
        adapter.addGroup(binding.etFragmentGroupInputText.text.toString())
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

}