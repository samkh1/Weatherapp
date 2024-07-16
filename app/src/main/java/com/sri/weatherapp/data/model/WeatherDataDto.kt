package com.sri.weatherapp.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class WeatherDataDto(
    @SerializedName("time") val time: List<Date>,
    @SerializedName("temperature_2m") val temperature: List<Double>,
    @SerializedName("relative_humidity_2m") val humidity: List<Int>,
    @SerializedName("wind_speed_10m") val wind: List<Double>

)
