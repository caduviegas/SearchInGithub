package com.innaval.searchingithub.di

import com.innaval.searchingithub.data.datasource.UserApi
import com.innaval.searchingithub.data.repository.UserRepositoryImplementation
import com.innaval.searchingithub.domain.repository.UserRepository
import com.innaval.searchingithub.domain.usecase.AllUsersUseCase
import com.innaval.searchingithub.domain.usecase.AllUsersUseCaseImplementation
import com.innaval.searchingithub.domain.usecase.UserInformationsUseCase
import com.innaval.searchingithub.domain.usecase.UserInformationsUseCaseImplementation
import com.innaval.searchingithub.domain.usecase.UserUseCase
import com.innaval.searchingithub.domain.usecase.UserUseCaseImplementation
import com.innaval.searchingithub.presentation.user.info.UserInfoViewModel
import com.innaval.searchingithub.presentation.user.search.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun allModules() = listOf(
    apiModule,
    repositoriesModule,
    useCasesModule,
    viewModelsModule
)

private val apiModule = module {
    single {
        provideUserApi()
    }
}

private fun provideUserApi(): UserApi {
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(UserApi::class.java)
}

private val repositoriesModule = module {
    single<UserRepository> { UserRepositoryImplementation(get()) }
}

private val useCasesModule = module {
    single<AllUsersUseCase> { AllUsersUseCaseImplementation(get()) }
    single<UserUseCase> { UserUseCaseImplementation(get()) }
    single<UserInformationsUseCase> { UserInformationsUseCaseImplementation(get()) }
}

private val viewModelsModule = module {
    viewModel { UserViewModel(get(), get()) }
    viewModel { UserInfoViewModel(get(), get()) }
}