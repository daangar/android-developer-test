package com.dgarcia.data.util

import com.dgarcia.data.database.model.WeatherEntity
import com.dgarcia.data.networking.model.MainInfo
import com.dgarcia.data.networking.model.WeatherInfoResponse
import okhttp3.MediaType
import okhttp3.ResponseBody

const val SAN_SALVADOR_CITY_NAME = "San Salvador"
const val FAKE_FAILURE_ERROR_CODE = 400

val successWeatherInfoResponse = WeatherInfoResponse(0, arrayListOf(), MainInfo(), "")
val failureResponseBody = ResponseBody.create(MediaType.parse("text"), "network error")
val fakeWeatherEntity = WeatherEntity(0, arrayListOf(), MainInfo(), "")
