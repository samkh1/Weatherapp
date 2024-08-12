package com.sri.weatherapp.domain.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class CurrentWeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double
)
