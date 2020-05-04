package com.dgarcia.domain.interaction.car

import com.dgarcia.domain.repository.CarRepository

class GetCarUseCaseImpl(private val carRepository: CarRepository): GetCarUseCase {
    override suspend fun invoke(param: String) = carRepository.getCarByPlate(param)
}