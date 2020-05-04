package com.dgarcia.data.di

import androidx.room.Room
import com.dgarcia.data.database.ParkingDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


private const val PARKING_DB = "parking-database"

val databaseModule = module {

  single {
    Room.databaseBuilder(androidContext(), ParkingDatabase::class.java, PARKING_DB).fallbackToDestructiveMigration().build()
  }

  factory { get<ParkingDatabase>().carDao() }
}