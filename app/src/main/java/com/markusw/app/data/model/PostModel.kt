package com.markusw.app.data.model

import com.google.gson.annotations.SerializedName

data class PostModel(
    @SerializedName("titulo")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("imagenUrl")
    val imageURL: String
)
