package com.sirfilbido.bookofstarwars.app

import android.app.Application
import com.sirfilbido.bookofstarwars.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BoSWApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BoSWApp)
            modules(appModule())
        }
    }
}