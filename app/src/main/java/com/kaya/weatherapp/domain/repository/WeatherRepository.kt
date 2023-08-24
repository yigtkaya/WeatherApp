package com.kaya.weatherapp.domain.repository

import com.kaya.weatherapp.domain.util.Resource
import com.kaya.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, lon: Double): Resource<WeatherInfo>
}