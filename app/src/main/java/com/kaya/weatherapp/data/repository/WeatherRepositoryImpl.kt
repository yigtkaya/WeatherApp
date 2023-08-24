package com.kaya.weatherapp.data.repository

import com.kaya.weatherapp.data.mappers.toWeatherInfo
import com.kaya.weatherapp.data.remote.WeatherApi
import com.kaya.weatherapp.domain.repository.WeatherRepository
import com.kaya.weatherapp.domain.util.Resource
import com.kaya.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api : WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, lon: Double): Resource<WeatherInfo> {
        return try {
                Resource.Success(
                    data = api.getWeather(lat, lon).toWeatherInfo()
                )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

}