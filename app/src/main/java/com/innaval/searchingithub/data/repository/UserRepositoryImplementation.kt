package com.innaval.searchingithub.data.repository

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.data.datasource.UserApi
import com.innaval.searchingithub.data.datasource.safeApiCall
import com.innaval.searchingithub.domain.model.UserInformationsModel
import com.innaval.searchingithub.domain.model.UserModel
import com.innaval.searchingithub.domain.repository.UserRepository

class UserRepositoryImplementation (
    private val userApi: UserApi,
) : UserRepository {

    override suspend fun getAllUsers() = safeApiCall { userApi.getAllUsers() }

    override suspend fun getUser(login: String?): ResponseAny<UserModel> = safeApiCall { userApi.getUser(login) }

    override suspend fun getUserRepos(login: String): ResponseAny<List<UserInformationsModel>> = safeApiCall { userApi.getUserInformation(login) }
}
