package com.sri.weatherapp.data

import com.sri.weatherapp.data.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/forecast&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m")
    suspend fun getTempurature(
        @Query("longitude") long: Double,
        @Query("latitude") lat: Double,
    ): WeatherDto
}
