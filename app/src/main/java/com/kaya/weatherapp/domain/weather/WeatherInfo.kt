package com.kaya.weatherapp.domain.weather

data class WeatherInfo (
    val weatherPerDay: Map<Int, List<WeatherData>>,
    val currentWeather: WeatherData?
)