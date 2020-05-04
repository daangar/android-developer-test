package com.dgarcia.parkingapp.common

import com.dgarcia.domain.model.Car
import com.dgarcia.parkingapp.model.CarApp

// App Converters
fun CarApp.toDomainModel() = Car(plate, type)


// Domain Converters
fun Car.toAppModel() = CarApp(plate, type)