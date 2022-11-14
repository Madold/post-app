package app.domain.usecases

import app.data.PostsRepository
import javax.inject.Inject

class GetAllPost @Inject constructor(
    private val repository: PostsRepository
) {

    suspend operator fun invoke() = repository.getAllPost()
}