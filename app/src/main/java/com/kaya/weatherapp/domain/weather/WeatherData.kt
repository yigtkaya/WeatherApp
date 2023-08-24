package com.kaya.weatherapp.domain.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val humidity: Double,
    val weatherType: WeatherType,
    val windSpeed: Double
)
