package com.kaya.weatherapp.data.mappers

import com.kaya.weatherapp.data.remote.WeatherDataDto
import com.kaya.weatherapp.data.remote.WeatherDto
import com.kaya.weatherapp.domain.weather.WeatherData
import com.kaya.weatherapp.domain.weather.WeatherInfo
import com.kaya.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class IndexedWeather(
    val index : Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDataMap() : Map<Int, List<WeatherData>> {

    return time.mapIndexed { index, time ->

        val temprature = temperatures[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]

        IndexedWeather(
            index, WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temprature,
                pressure = pressure,
                humidity = humidity,
                windSpeed = windSpeed,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy{
        it.index / 24
    }.mapValues { it ->
        it.value.map {
            it.data
        }
    }
}

fun WeatherDto.toWeatherInfo() : WeatherInfo {

    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = when {
            now.minute < 30 -> now.hour
            now.hour == 23 -> 12.00
            else -> now.hour + 1
        }
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherPerDay = weatherDataMap,
        currentWeather = currentWeatherData
    )
}