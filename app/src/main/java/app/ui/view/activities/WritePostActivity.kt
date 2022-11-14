package app.ui.view.activities

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import app.core.interfaces.Initalizer
import app.core.utils.FileUtils
import app.ui.viewmodel.WritePostViewModel
import com.markusw.postsapp.databinding.ActivityWritePostBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody

@AndroidEntryPoint
class WritePostActivity: Initalizer, AppCompatActivity() {

    private lateinit var binding: ActivityWritePostBinding
    private val viewModel: WritePostViewModel by viewModels()
    private val imagePicker = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->

        uri.let {
            binding.postImagePreview.setImageURI(it)
            selectedGalleryImageUri = it!!
            println(selectedGalleryImageUri.toString())
        }

        //no image

    }
    private lateinit var selectedGalleryImageUri: Uri

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
            openUserGallery()
        }

        binding.sendPostBtn.setOnClickListener {
            savePostToBackend()
        }

    }

    private fun openUserGallery() {
        imagePicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private fun savePostToBackend() {
        val postTitle = binding.inputPostTitle.text.toString()
        val postDescription = binding.textAreaPostDescription.text.toString()
        val postImageURI = this.selectedGalleryImageUri
        val imgFile = FileUtils.getFileFromUri(this, postImageURI)
        val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imgFile);
        val body = MultipartBody.Part.createFormData("file", imgFile.name, requestFile);

        println("titulo: $postTitle desc: $postDescription")

        //viewModel.savePostToBackend(postTitle, postDescription, body)
    }

    @Suppress("DEPRECATION")
    private fun switchToMainActivity() {
        super.onBackPressed()
    }


}