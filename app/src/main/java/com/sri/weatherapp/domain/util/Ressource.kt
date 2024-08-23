package com.sri.weatherapp.domain.util

sealed class Ressource<T>(var data: T? = null, var error: String? = null) {
     data class Success<T>(var d: T?) : Ressource<T>(data = d)
     data class Error<T>(var err: String?) : Ressource<T>(error = err)
}
