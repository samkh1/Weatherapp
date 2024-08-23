package com.sri.weatherapp.domain.repository

import com.sri.weatherapp.domain.model.WeatherList
import com.sri.weatherapp.domain.util.Ressource

interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): Ressource<WeatherList>
}
