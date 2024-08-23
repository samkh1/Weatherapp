package com.sri.weatherapp.domain

sealed class Ressource<T> (val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Ressource<T>(data)
    class Error<T>(data: T?, message: String?) : Ressource<T>(data, message)
}
