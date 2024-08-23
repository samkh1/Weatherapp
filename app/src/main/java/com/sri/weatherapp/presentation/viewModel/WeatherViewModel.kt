package com.sri.weatherapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sri.weatherapp.domain.WeatherState
import com.sri.weatherapp.domain.location.LocationTracker
import com.sri.weatherapp.domain.repository.WeatherRepository
import com.sri.weatherapp.domain.util.Ressource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val location: LocationTracker,
) : ViewModel() {
    var state by mutableStateOf(WeatherState())
        private set

    init {
        loadTempurature()
    }

    fun loadTempurature() {
        viewModelScope.launch {
            state.copy(isLoading = true)
            location.getCurrentLocation()?.let {
                when (val result = repository.getWeather(it.latitude, it.longitude)) {
                    is Ressource.Success -> {
                        state = state.copy(
                            isLoading = false,
                            weatherData = result.d,
                            isError = null,
                        )
                    }

                    is Ressource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            weatherData = null,
                            isError = result.err,
                        )
                    }
                }
            } ?: kotlin.run {
                state.copy(
                    weatherData = null,
                    isLoading = false,
                    isError = "No location found!",
                )
            }
        }
    }
}
