package com.sri.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherDto(
    @SerializedName("time")
    val time: String,

    @SerializedName("interval")
    val interval: String,

    @SerializedName("temperature_2m")
    val tempurature: String,

    @SerializedName("wind_speed_10m")
    val wind: String,
)
