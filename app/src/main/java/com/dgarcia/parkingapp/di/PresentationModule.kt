package com.dgarcia.parkingapp.di

import com.dgarcia.parkingapp.ui.car.CarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CarViewModel(get()) }
}