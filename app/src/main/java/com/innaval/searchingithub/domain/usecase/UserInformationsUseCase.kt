package com.innaval.searchingithub.domain.usecase

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.domain.model.UserInformationsModel

interface UserInformationsUseCase {
    suspend operator fun invoke(name: String): ResponseAny<List<UserInformationsModel>>
}