package app.domain.usecases

import app.data.PostsRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class SavePost @Inject constructor(
    private val repository: PostsRepository
) {

    suspend operator fun invoke(title: String, description: String, imgFile: MultipartBody.Part) {
        repository.savePost(title, description, imgFile)
    }

}