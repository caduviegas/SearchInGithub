package com.innaval.searchingithub.domain.usecase

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.data.datasource.ResponseEmpty
import com.innaval.searchingithub.data.datasource.ResponseError
import com.innaval.searchingithub.data.datasource.ResponseSuccess
import com.innaval.searchingithub.domain.model.UserInformationsModel
import com.innaval.searchingithub.domain.repository.UserRepository

class UserInformationsUseCaseImplementation (
    private val userRepository: UserRepository,
) : UserInformationsUseCase {

    override suspend fun invoke(name: String): ResponseAny<List<UserInformationsModel>> {
        return when (val result = userRepository.getUserRepos(name)) {
            is ResponseSuccess -> result
            is ResponseEmpty -> result
            is ResponseError -> result
        }
    }
}