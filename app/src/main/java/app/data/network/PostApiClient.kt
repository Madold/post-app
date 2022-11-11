package app.data.network

import app.data.model.PostModel
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface PostApiClient {

    @GET("post")
    suspend fun getAllPosts(): Response<List<PostModel>>

    /*
    @Multipart
    @POST("post")
    suspend fun savePost(
        @Part("titulo") titulo: String,
        @Part("description") description: String,
        @Part("file") file: MultipartBody.Part
    )*/

}


