package com.sri.weatherapp.domain.model

data class WeatherList(
    var weathers: Map<Int, List<WeatherData>>,
    var currentWeatherData: WeatherData?
)
