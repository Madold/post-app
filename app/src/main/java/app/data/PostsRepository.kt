package app.data

import app.data.model.PostModel
import app.data.network.PostApiService
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val api: PostApiService
) {

    suspend fun getAllPost(): List<PostModel> {
        return api.getAllPosts() ?: emptyList()
    }

}