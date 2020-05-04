package com.dgarcia.data.networking.model

import com.dgarcia.data.database.model.CarEntity
import com.dgarcia.data.networking.base.RoomMapper
import com.dgarcia.domain.model.CarType

data class CarInfoResponse(
    val plate: String,
    val type: String
) : RoomMapper<CarEntity> {
    override fun mapToRoomEntity() =
        CarEntity(plate, type)
}

data class Car (val plate: String, val type: String)