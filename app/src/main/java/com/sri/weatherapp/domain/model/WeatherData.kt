package com.sri.weatherapp.domain.model

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Int,
    val windSpeed: Double,
    val humidity: Double?
)
