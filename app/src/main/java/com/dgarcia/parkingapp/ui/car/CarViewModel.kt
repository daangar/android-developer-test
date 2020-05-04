package com.dgarcia.parkingapp.ui.car

import com.dgarcia.domain.interaction.car.RegisterCarUseCase
import com.dgarcia.domain.model.Car
import com.dgarcia.domain.model.onFailure
import com.dgarcia.domain.model.onSuccess
import com.dgarcia.parkingapp.common.toDomainModel
import com.dgarcia.parkingapp.model.CarApp
import com.dgarcia.parkingapp.ui.base.BaseViewModel
import com.dgarcia.parkingapp.ui.base.Error
import com.dgarcia.parkingapp.ui.base.Success

class CarViewModel(private val registerCar: RegisterCarUseCase) : BaseViewModel<Car>() {
    fun registerCar(car: CarApp) = executeUseCase {
        val carModel = car.toDomainModel()
        registerCar(carModel)
            .onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }
}