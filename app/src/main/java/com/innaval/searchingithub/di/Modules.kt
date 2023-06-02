package com.innaval.searchingithub.di

import com.innaval.searchingithub.data.datasource.UserApi
import com.innaval.searchingithub.data.repository.UserRepositoryImplementation
import com.innaval.searchingithub.domain.repository.UserRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun allModules() = listOf(
    apiModule,
    repositoriesModule,
)

private val apiModule = module {
    single {
        provideUserApi()
    }
}

private fun provideUserApi(): UserApi{
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(UserApi::class.java)
}

private val repositoriesModule = module{
    single<UserRepository>{UserRepositoryImplementation(get())}
}