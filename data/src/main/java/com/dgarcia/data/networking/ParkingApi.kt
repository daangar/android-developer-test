package com.dgarcia.data.networking

import com.dgarcia.data.networking.model.Car
import com.dgarcia.data.networking.model.CarInfoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ParkingApi {

    @POST("registerCar")
    suspend fun registerCar(@Body car: Car): Response<CarInfoResponse>

    @GET("getCarByPlate")
    suspend fun getCarByPlate(@Query("plate") plate: String): Response<CarInfoResponse>

    @GET("getCarList")
    suspend fun getCarList() : Response<List<CarInfoResponse>>
}