package app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.domain.usecases.SavePost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class WritePostViewModel @Inject constructor(
    private val savePost: SavePost
) : ViewModel() {

    fun savePostToBackend(title: String, description: String, imgFile: MultipartBody.Part) {
        viewModelScope.launch {
            savePost(title, description, imgFile)
        }
    }

}