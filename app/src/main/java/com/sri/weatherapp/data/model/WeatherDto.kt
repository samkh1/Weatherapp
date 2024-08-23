package com.sri.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("hourly")
    val hourly: WeatherDataDto,

    @SerializedName("current")
    val current: CurrentWeatherDto,
)
