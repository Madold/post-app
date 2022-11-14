package app.data.network

import app.data.model.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import javax.inject.Inject

class PostApiService @Inject constructor(
    private val api: PostApiClient
) {

    suspend fun getAllPosts(): List<PostModel>? {

        return try {
             withContext(Dispatchers.IO) {
                 val response = api.getAllPosts()

                 if (response.isSuccessful) {
                     return@withContext response.body()
                 }

                 return@withContext emptyList()

             }
        } catch (e: Exception) {
            emptyList()
        }

    }

    suspend fun savePost(title: String, description: String, imgFile: MultipartBody.Part) {
       withContext(Dispatchers.IO) {
           api.savePost(title, description, imgFile)
       }
    }

}