package com.markusw.app.ui.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.markusw.app.core.interfaces.Initalizer
import com.markusw.postsapp.databinding.ActivityWritePostBinding

class WritePostActivity: Initalizer, AppCompatActivity() {

    private lateinit var binding: ActivityWritePostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritePostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupComponents()
        initObservers()
        initEventListeners()
    }

    override fun setupComponents() {

    }

    override fun initObservers() {

    }

    override fun initEventListeners() {
        binding.topAppBar.setNavigationOnClickListener {
            switchToMainActivity()
        }
    }

    @Suppress("DEPRECATION")
    private fun switchToMainActivity() {
        super.onBackPressed()
    }


}