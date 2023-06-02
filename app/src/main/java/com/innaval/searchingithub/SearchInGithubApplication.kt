package com.innaval.searchingithub

import android.app.Application
import com.innaval.searchingithub.di.allModules
import com.innaval.searchingithub.domain.model.UserModel
import com.innaval.searchingithub.domain.model.UserRepositoryModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import timber.log.Timber

class SearchInGithubApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        GlobalContext.startKoin {
            androidContext(this@SearchInGithubApplication)
            modules(allModules())
        }
    }
}