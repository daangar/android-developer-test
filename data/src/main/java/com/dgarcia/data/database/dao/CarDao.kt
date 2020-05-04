package com.dgarcia.data.database.dao

import androidx.room.*
import com.dgarcia.data.database.CAR_TABLE_NAME
import com.dgarcia.data.database.model.CarEntity

@Dao
interface CarDao {

    @Transaction
    suspend fun updateCarAndReturn(car: CarEntity): CarEntity {
        saveCarInfo(car)
        return getCarInfoByPlate(car.plate)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCarInfo(car: CarEntity)

    @Query("SELECT * FROM $CAR_TABLE_NAME WHERE plate = :plate LIMIT 1")
    suspend fun getCarInfoByPlate(plate: String = ""): CarEntity

}