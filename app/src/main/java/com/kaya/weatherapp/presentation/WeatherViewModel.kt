package com.kaya.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaya.weatherapp.data.locaiton.DefaultLocationTracker
import com.kaya.weatherapp.domain.repository.WeatherRepository
import com.kaya.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class WeatherViewModel
@Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: DefaultLocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState())

    suspend fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
        }
        locationTracker.getCurrentLocation()?.let { location ->
            when(val result = repository.getWeatherData(location.latitude, location.altitude)) {
                is Resource.Success -> {
                    state = WeatherState(
                        weatherInfo = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        } ?: kotlin.run {
            state = state.copy(
                isLoading = false,
                error = "Unable to get location"
            )
        }
    }
}