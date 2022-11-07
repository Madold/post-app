package com.markusw.app.domain.usecases

import com.markusw.app.data.PostsRepository
import javax.inject.Inject

class GetAllPost @Inject constructor(
    private val repository: PostsRepository
) {

    suspend operator fun invoke() = repository.getAllPost()

}