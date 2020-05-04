package com.dgarcia.domain.repository

import com.dgarcia.domain.model.Car
import com.dgarcia.domain.model.Result

interface CarRepository {
    suspend fun registerCar(car: Car): Result<Car>
    suspend fun getCarByPlate(plate: String): Result<Car>
}