package com.dgarcia.data.database

import androidx.room.TypeConverter
import com.dgarcia.data.networking.model.Car
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    private val gson = Gson()

    // car list converters

    @TypeConverter
    fun fromCarListToJson(list: List<Car>?): String {
        return list?.let { gson.toJson(it) } ?: ""
    }

    @TypeConverter
    fun fromJsonToCarList(jsonList: String): List<Car> {
        val listType = object : TypeToken<List<Car>>() {}.type
        return gson.fromJson(jsonList, listType)
    }
}