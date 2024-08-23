package com.sri.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherDataDto(
    @SerializedName("time")
    val time: List<String>,

    @SerializedName("temperature_2m")
    val temperature: List<String>,

    @SerializedName("relative_humidity_2m")
    val humidity: List<String>,

    @SerializedName("wind_speed_10m")
    val wind: List<String>,

)
