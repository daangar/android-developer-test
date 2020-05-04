package com.dgarcia.data

import com.nhaarman.mockitokotlin2.*
import com.dgarcia.data.common.utils.Connectivity
import com.dgarcia.data.database.dao.WeatherDao
import com.dgarcia.data.networking.WeatherApi
import com.dgarcia.data.repository.weather.WeatherRepositoryImpl
import com.dgarcia.data.util.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Response

class WeatherRepositoryTest {

    private val weatherTestApi: WeatherApi = mock()
    private val weatherDao: WeatherDao = mock()
    private val connectivity: Connectivity = mock()
    private val weatherRepository = WeatherRepositoryImpl(weatherTestApi, weatherDao)

    @Test
    fun `test getWeatherForLocation calls api and saves data to db upon success`() {
        runBlocking {
            whenever(connectivity.hasNetworkAccess()).thenReturn(true)
            whenever(weatherTestApi.getWeatherForLocation(SAN_SALVADOR_CITY_NAME)).thenReturn(
                Response.success(successWeatherInfoResponse)
            )
            whenever(weatherDao.updateWeatherAndReturn(successWeatherInfoResponse.mapToRoomEntity())).thenReturn(
                fakeWeatherEntity
            )
            weatherRepository.getWeatherForLocation(SAN_SALVADOR_CITY_NAME)

            verify(weatherTestApi, times(1)).getWeatherForLocation(SAN_SALVADOR_CITY_NAME)
            verify(weatherDao, times(1)).updateWeatherAndReturn(fakeWeatherEntity)
        }
    }

    @Test
    fun `test getWeatherForLocation calls api and returns cached data from db upon failure`() {
        runBlocking {
            whenever(connectivity.hasNetworkAccess()).thenReturn(true)
            whenever(weatherTestApi.getWeatherForLocation(SAN_SALVADOR_CITY_NAME))
                .thenReturn(Response.error(FAKE_FAILURE_ERROR_CODE, failureResponseBody))
            weatherRepository.getWeatherForLocation(SAN_SALVADOR_CITY_NAME)

            verify(weatherTestApi, times(1)).getWeatherForLocation(SAN_SALVADOR_CITY_NAME)
            verify(weatherDao, never()).updateWeatherAndReturn(fakeWeatherEntity)
        }
    }
}