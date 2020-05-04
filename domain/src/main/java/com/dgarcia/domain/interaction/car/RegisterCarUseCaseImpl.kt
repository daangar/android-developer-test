package com.dgarcia.domain.interaction.car

import com.dgarcia.domain.model.Car
import com.dgarcia.domain.repository.CarRepository

class RegisterCarUseCaseImpl(private val carRepository: CarRepository) : RegisterCarUseCase {
    override suspend fun invoke(param: Car) = carRepository.registerCar(param)
}