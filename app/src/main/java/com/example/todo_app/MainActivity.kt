package com.example.todo_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todo_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)

    supportFragmentManager
      .beginTransaction()
      .add(R.id.nav_host_fragment_content_main, GroupFragment())
      .commit()
  }

}