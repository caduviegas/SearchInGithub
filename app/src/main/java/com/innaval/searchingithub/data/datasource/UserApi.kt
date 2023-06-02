package com.innaval.searchingithub.data.datasource

import com.innaval.searchingithub.domain.model.UserModel
import com.innaval.searchingithub.domain.model.UserInformationsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users")
    suspend fun getAllUsers(): Response<List<UserModel>>

    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String?,
    ): Response<UserModel>

    @GET("users/{username}/repos")
    suspend fun getUserInformation(
        @Path("username") username: String,
    ): Response<List<UserInformationsModel>>
}