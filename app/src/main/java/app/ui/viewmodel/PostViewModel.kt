package app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.data.model.PostModel
import app.domain.usecases.GetAllPost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel
    @Inject constructor(
        private val getAllPost: GetAllPost
    ) : ViewModel()  {

    val isLoading = MutableLiveData<Boolean>()
    val isRefreshing = MutableLiveData<Boolean>()
    val posts = MutableLiveData<List<PostModel>>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val response = getAllPost()
            posts.postValue(response.reversed())

            isLoading.postValue(false)
        }
    }

    fun refreshPosts() {
        viewModelScope.launch {
            isRefreshing.postValue(true)

            val response = getAllPost()
            posts.postValue(response.reversed())

            isRefreshing.postValue(false)

        }
    }




}