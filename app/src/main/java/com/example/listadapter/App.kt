package com.example.listadapter

import android.app.Application
import com.example.listadapter.di.appModule
import com.example.listadapter.di.networkModule
import com.example.listadapter.di.viewModelModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule, viewModelModule, networkModule)
        }
    }
}