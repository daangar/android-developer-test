package com.dgarcia.data.di


import com.dgarcia.data.common.utils.Connectivity
import com.dgarcia.data.common.utils.ConnectivityImpl
import com.dgarcia.data.common.utils.FakeConnectivityImpl
import com.dgarcia.data.repository.car.CarRepositoryImpl
import com.dgarcia.domain.repository.CarRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<CarRepository> { CarRepositoryImpl(get(), get()) }
    factory<Connectivity> { FakeConnectivityImpl(androidContext()) }
}