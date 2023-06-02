package com.innaval.searchingithub

import android.app.Application
import com.innaval.searchingithub.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
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