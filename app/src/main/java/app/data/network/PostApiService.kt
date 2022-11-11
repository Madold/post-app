package app.data.network

import app.data.model.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostApiService @Inject constructor(
    private val api: PostApiClient
) {

    suspend fun getAllPosts(): List<PostModel>? {
        /*
        return withContext(Dispatchers.IO) {
            val response = api.getAllPosts()

            response.body()
        }*/


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

}