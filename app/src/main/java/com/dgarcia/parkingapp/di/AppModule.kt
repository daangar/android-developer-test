package com.dgarcia.parkingapp.di

import com.dgarcia.data.common.coroutine.CoroutineContextProvider
import org.koin.dsl.module

val appModule = module {
    single { CoroutineContextProvider() }
}