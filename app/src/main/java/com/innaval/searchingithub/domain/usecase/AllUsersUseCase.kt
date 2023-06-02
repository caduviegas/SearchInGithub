package com.innaval.searchingithub.domain.usecase

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.domain.model.UserModel

interface AllUsersUseCase {

    suspend operator fun invoke(): ResponseAny<List<UserModel>>
}