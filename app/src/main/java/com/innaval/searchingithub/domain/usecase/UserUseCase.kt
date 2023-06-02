package com.innaval.searchingithub.domain.usecase

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.domain.model.UserModel

interface UserUseCase {
    suspend operator fun invoke(login: String?): ResponseAny<UserModel>
}