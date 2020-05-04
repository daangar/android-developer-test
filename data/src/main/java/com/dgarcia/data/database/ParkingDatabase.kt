package com.dgarcia.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dgarcia.data.database.dao.CarDao
import com.dgarcia.data.database.model.CarEntity

@Database(entities = [CarEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ParkingDatabase: RoomDatabase() {
    abstract fun carDao(): CarDao
}