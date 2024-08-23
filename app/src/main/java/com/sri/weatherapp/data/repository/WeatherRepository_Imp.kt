package com.sri.weatherapp.data.repository


import com.sri.weatherapp.data.ApiService
import com.sri.weatherapp.data.model.getWeatherList
import com.sri.weatherapp.domain.model.WeatherList
import com.sri.weatherapp.domain.repository.WeatherRepository
import com.sri.weatherapp.domain.util.Ressource
import java.lang.Exception
import javax.inject.Inject


class WeatherRepository_Imp @Inject constructor(
    private val apiService: ApiService,
) : WeatherRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double): Ressource<WeatherList> {
        return try {
                Ressource.Success(apiService.getTempurature(latitude, longitude).getWeatherList())
        } catch (e: Exception) {
            Ressource.Error(e.message ?: "An anknown error occured")
        }
    }
}

