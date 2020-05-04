package com.dgarcia.domain.di


import com.dgarcia.domain.interaction.car.*
import org.koin.dsl.module

val interactionModule = module {
    //Car's UseCases
    factory<RegisterCarUseCase> {RegisterCarUseCaseImpl(get())}
    factory<GetCarUseCase> {GetCarUseCaseImpl(get())}
}
