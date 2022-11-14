package app.data

import app.data.model.PostModel
import app.data.network.PostApiService
import okhttp3.MultipartBody
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val api: PostApiService
) {

    suspend fun getAllPost(): List<PostModel> {
        return api.getAllPosts() ?: emptyList()
    }

    suspend fun savePost(title: String, description: String, imgFile: MultipartBody.Part) {
        api.savePost(title, description, imgFile)
    }

}