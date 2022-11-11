package app.ui.view.activities

import android.os.Bundle
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import app.core.interfaces.Initalizer
import com.markusw.postsapp.databinding.ActivityWritePostBinding

class WritePostActivity: Initalizer, AppCompatActivity() {

    private lateinit var binding: ActivityWritePostBinding
    private val imagePicker = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->

        uri.let {
            binding.postImagePreview.setImageURI(it)
        }

        //no image

    }

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

        binding.pickImageBtn.setOnClickListener {
            imagePicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

    }

    @Suppress("DEPRECATION")
    private fun switchToMainActivity() {
        super.onBackPressed()
    }


}