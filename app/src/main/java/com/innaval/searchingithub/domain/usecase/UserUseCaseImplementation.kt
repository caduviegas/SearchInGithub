package com.innaval.searchingithub.domain.usecase

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.data.datasource.ResponseEmpty
import com.innaval.searchingithub.data.datasource.ResponseError
import com.innaval.searchingithub.data.datasource.ResponseSuccess
import com.innaval.searchingithub.domain.model.UserModel
import com.innaval.searchingithub.domain.repository.UserRepository

class UserUseCaseImplementation(
    private val userRepository: UserRepository,
) : UserUseCase {

    override suspend fun invoke(login: String?): ResponseAny<UserModel> {
        return when (val result = userRepository.getUser(login)) {
            is ResponseSuccess -> result
            is ResponseEmpty -> result
            is ResponseError -> result
        }
    }
}