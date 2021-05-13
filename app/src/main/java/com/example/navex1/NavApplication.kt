package com.example.navex1

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.example.navex1.di.appModule
import org.koin.core.context.startKoin

class NavApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(appModule))
        }
    }
}