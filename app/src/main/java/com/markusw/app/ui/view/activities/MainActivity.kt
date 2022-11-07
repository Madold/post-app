package com.markusw.app.ui.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.markusw.app.core.interfaces.Initalizer
import com.markusw.app.ui.view.adapters.PostsAdapter
import com.markusw.app.ui.viewmodel.PostViewModel
import com.markusw.postsapp.R
import com.markusw.postsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


//TODO: Agregar blur a las cards
//TODO: Agregar swipe refresh a el recycler view
//TODO: Si es posible implementar un sticky header
//TODO: Agregar la funcionalidad de redactar un post

@AndroidEntryPoint
class MainActivity: Initalizer, AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: PostViewModel by viewModels()
    private lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.onCreate()
        setupComponents()
        initObservers()
        initEventListeners()
    }

    override fun setupComponents() {
        //Setup the recycler view
        adapter = PostsAdapter()
        //Setup the layout manager
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.COLUMN
        layoutManager.flexWrap = FlexWrap.NOWRAP

        binding.postsRecyclerView.adapter = adapter
        binding.postsRecyclerView.layoutManager = layoutManager
    }

    override fun initObservers() {
        viewModel.isLoading.observe(this) { visible ->
            binding.loadingSpinner.isVisible = visible
        }

        viewModel.posts.observe(this) { posts ->
            adapter.setPosts(posts)
        }
    }

    override fun initEventListeners() {

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.writePostIcon -> switchToWritePostActivity()
                }
            return@setOnMenuItemClickListener true
        }

    }

    private fun switchToWritePostActivity() {
        startActivity(Intent(this, WritePostActivity::class.java))
        finish()
    }



}