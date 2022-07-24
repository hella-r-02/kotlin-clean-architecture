package com.example.clean.app

import android.app.Application
import com.example.clean.BuildConfig
import com.example.clean.dl.appModule
import com.example.clean.dl.dataModule
import com.example.clean.dl.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}