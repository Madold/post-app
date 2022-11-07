package com.markusw.app.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.markusw.postsapp.databinding.ActivityWritePostBinding
import com.markusw.app.core.interfaces.Initalizer

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

    private fun switchToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        switchToMainActivity()
        super.onBackPressed()
    }


}