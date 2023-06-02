package com.innaval.searchingithub.domain.usecase

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.data.datasource.ResponseEmpty
import com.innaval.searchingithub.data.datasource.ResponseError
import com.innaval.searchingithub.data.datasource.ResponseSuccess
import com.innaval.searchingithub.domain.model.UserModel
import com.innaval.searchingithub.domain.repository.UserRepository

class AllUsersUseCaseImplementation (
    private val userRepository: UserRepository,
) : AllUsersUseCase {

    override suspend fun invoke(): ResponseAny<List<UserModel>> {
        return when (val result = userRepository.getAllUsers()) {
            is ResponseSuccess -> result
            is ResponseEmpty -> result
            is ResponseError -> result
        }
    }
}