package com.dgarcia.data.common

import com.dgarcia.data.database.model.CarEntity
import com.dgarcia.domain.model.Car

fun Car.toCarNetworkModel() = com.dgarcia.data.networking.model.Car (
    plate, type.toString()
)

fun Car.toCarEntityModel() = CarEntity(
    plate, type.toString()
)