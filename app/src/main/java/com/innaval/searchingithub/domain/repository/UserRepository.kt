package com.innaval.searchingithub.domain.repository

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.domain.model.UserInformationsModel
import com.innaval.searchingithub.domain.model.UserModel

interface UserRepository {

    suspend fun getAllUsers(): ResponseAny<List<UserModel>>

    suspend fun getUser(login: String?): ResponseAny<UserModel>

    suspend fun getUserRepos(login: String): ResponseAny<List<UserInformationsModel>>
}