package com.sri.weatherapp.domain

import com.sri.weatherapp.domain.model.WeatherList

data class WeatherState(
    val weatherData: WeatherList? = null,
    val isLoading: Boolean = false,
    val isError: String? = null
)
