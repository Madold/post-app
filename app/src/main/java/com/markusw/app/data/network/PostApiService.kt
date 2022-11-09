package com.markusw.app.data.network

import android.util.Log
import android.widget.Toast
import com.markusw.app.data.model.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostApiService @Inject constructor(
    private val api: PostApiClient
) {

    suspend fun getAllPosts(): List<PostModel>? {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getAllPosts()

                if (response.isSuccessful) {
                    response.body()
                }
                emptyList()
            }
        } catch (e: Exception) {

            Log.d("Conection", e.message + "")

            emptyList()
        }
    }

}