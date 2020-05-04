package com.dgarcia.domain.interaction.car

import com.dgarcia.domain.base.BaseUseCase
import com.dgarcia.domain.model.Car
import com.dgarcia.domain.model.Result

interface GetCarUseCase : BaseUseCase<String, Car> {
    override suspend fun invoke(param: String): Result<Car>
}