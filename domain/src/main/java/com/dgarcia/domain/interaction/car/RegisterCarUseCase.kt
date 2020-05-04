package com.dgarcia.domain.interaction.car

import com.dgarcia.domain.base.BaseUseCase
import com.dgarcia.domain.model.Car
import com.dgarcia.domain.model.Result

interface RegisterCarUseCase : BaseUseCase<Car, Car> {
    override suspend operator fun invoke(param: Car): Result<Car>
}