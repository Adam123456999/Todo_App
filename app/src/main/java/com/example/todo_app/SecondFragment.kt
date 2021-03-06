package com.example.todo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todo_app.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

  private var _binding: FragmentSecondBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    _binding = FragmentSecondBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.buttonSecond.setOnClickListener {
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}