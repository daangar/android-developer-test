package com.dgarcia.data.repository.car

import com.dgarcia.data.common.toCarEntityModel
import com.dgarcia.data.common.toCarNetworkModel
import com.dgarcia.data.database.dao.CarDao
import com.dgarcia.data.database.model.CarEntity
import com.dgarcia.data.networking.ParkingApi
import com.dgarcia.data.networking.base.getData
import com.dgarcia.data.repository.BaseRepository
import com.dgarcia.domain.model.Car
import com.dgarcia.domain.model.Result
import com.dgarcia.domain.repository.CarRepository

class CarRepositoryImpl(
    private val parkingApi: ParkingApi,
    private val carDao: CarDao
) : BaseRepository<Car, CarEntity>(), CarRepository {

    override suspend fun registerCar(car: Car): Result<Car> {
        return fetchData(
            apiDataProvider = {

                val carData = car.toCarNetworkModel()

                parkingApi.registerCar(carData).getData(
                    fetchFromCacheAction = { carDao.getCarInfoByPlate(car.plate) },
                    cacheAction = {carDao.saveCarInfo(it)}
                )
            },
            dbDataProvider = { carDao.updateCarAndReturn(car.toCarEntityModel()) }
        )
    }

    override suspend fun getCarByPlate(plate: String): Result<Car> {
        return fetchData(
            apiDataProvider = {
                parkingApi.getCarByPlate(plate).getData(
                    fetchFromCacheAction = {carDao.getCarInfoByPlate(plate)},
                    cacheAction = {}
                )
            },
            dbDataProvider = {carDao.getCarInfoByPlate(plate)}
        )
    }

}