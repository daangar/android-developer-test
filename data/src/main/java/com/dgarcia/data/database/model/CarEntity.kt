package com.dgarcia.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dgarcia.data.database.CAR_TABLE_NAME
import com.dgarcia.data.networking.base.DomainMapper
import com.dgarcia.domain.model.Car
import com.dgarcia.domain.model.CarType

@Entity(tableName = CAR_TABLE_NAME)
data class CarEntity(
    @PrimaryKey val plate: String,
    val type: String
) : DomainMapper<Car> {

    override fun mapToDomainModel() =
        Car(plate, CarType.valueOf(type))
}