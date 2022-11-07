package com.markusw.app.data.network

import com.markusw.app.data.model.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostApiService @Inject constructor(
    private val api: PostApiClient
) {

    suspend fun getAllPosts(): List<PostModel>? {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPosts()
            response.body()
        }
    }

}