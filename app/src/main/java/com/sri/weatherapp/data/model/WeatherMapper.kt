package com.sri.weatherapp.data.model

import android.util.Log
import com.sri.weatherapp.domain.model.WeatherData
import com.sri.weatherapp.domain.model.WeatherList
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class WeatherIndex(
    var index: Int,
    var weatherData: WeatherData,
)

    fun toCurrentWeather(currentWeatherDto: CurrentWeatherDto): WeatherData {
        return currentWeatherDto.run {
            WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                temperatureCelsius = tempurature.toInt(),
                windSpeed = tempurature.toDouble(),
                humidity = null,
            )
        }
    }

    fun WeatherDataDto.toWeatherData(): Map<Int, List<WeatherData>> {
        return time.mapIndexed { index, time ->
            var weather = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature[index].toInt(),
                humidity = humidity[index].toDouble(),
                windSpeed = wind[index].toDouble(),
            )
            WeatherIndex(
                index,
                weather,

            )
        }.groupBy {
            it.index / 24
        }.mapValues {
            it.value.map { it.weatherData }
        }
    }

    fun WeatherDto.getWeatherList(): WeatherList {
        val weatherList = hourly.toWeatherData()
        val now = LocalDateTime.now()

        val currentWeatherData = weatherList[0]?.find {
            val hour = if (now.minute < 30) now.hour else now.hour + 1
            it.time.hour == hour
        }
        return WeatherList(
            weathers = weatherList,
            currentWeatherData = currentWeatherData,
        )
    }

