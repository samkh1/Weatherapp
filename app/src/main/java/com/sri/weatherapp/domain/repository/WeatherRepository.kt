package com.sri.weatherapp.domain.model.repository

interface WeatherMapper {
    suspend fun getWeather(wr)
}