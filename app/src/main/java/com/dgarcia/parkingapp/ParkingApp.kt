package com.dgarcia.parkingapp

import android.app.Application
import com.dgarcia.data.di.databaseModule
import com.dgarcia.data.di.networkingModule
import com.dgarcia.data.di.repositoryModule
import com.dgarcia.domain.di.interactionModule
import com.dgarcia.parkingapp.di.appModule
import com.dgarcia.parkingapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ParkingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@ParkingApp)
            modules(appModules + domainModules + dataModules)
        }
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}

val appModules = listOf(presentationModule, appModule)
val domainModules = listOf(interactionModule)
val dataModules = listOf(networkingModule, repositoryModule, databaseModule)
