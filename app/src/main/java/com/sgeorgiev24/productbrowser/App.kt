package com.sgeorgiev24.productbrowser

import android.app.Application
import com.sgeorgiev24.productbrowser.presentation.presentationModule
import com.sgeorgiev24.productbrowser.provider.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            modules(presentationModule + networkModule)
            androidLogger()
            androidContext(this@App)
        }
    }
}
