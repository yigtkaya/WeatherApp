package com.kaya.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.kaya.weatherapp.R

sealed class WeatherType (
    val weatherDescription: String,
    @DrawableRes val weatherIcon: Int
) {
    object ClearSky : WeatherType(
        weatherDescription = "Clear sky",
        weatherIcon = R.drawable.ic_sunny
    )
    object MainlyClear : WeatherType(
        weatherDescription = "Mainly clear",
        weatherIcon = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WeatherType(
        weatherDescription = "Partly cloudy",
        weatherIcon = R.drawable.ic_cloudy
    )
    object Foggy : WeatherType(
        weatherDescription = "Foggy",
        weatherIcon = R.drawable.ic_very_cloudy
    )
    object DepositingRimeFog : WeatherType(
        weatherDescription = "Depositing rime fog",
        weatherIcon = R.drawable.ic_very_cloudy
    )
    object LightDrizzle : WeatherType(
        weatherDescription = "Light drizzle",
        weatherIcon = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WeatherType(
        weatherDescription = "Moderate drizzle",
        weatherIcon = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WeatherType(
        weatherDescription = "Dense drizzle",
        weatherIcon = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WeatherType(
        weatherDescription = "Slight freezing drizzle",
        weatherIcon = R.drawable.ic_snowyrainy
    )
    object DenseFreezingDrizzle : WeatherType(
        weatherDescription = "Dense freezing drizzle",
        weatherIcon = R.drawable.ic_snowyrainy
    )
    object SlightRain : WeatherType(
        weatherDescription = "Slight rain",
        weatherIcon = R.drawable.ic_rainy
    )
    object ModerateRain : WeatherType(
        weatherDescription = "Rainy",
        weatherIcon = R.drawable.ic_rainy
    )
    object HeavyRain : WeatherType(
        weatherDescription = "Heavy rain",
        weatherIcon = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WeatherType(
        weatherDescription = "Heavy freezing rain",
        weatherIcon = R.drawable.ic_snowyrainy
    )
    object SlightSnowFall: WeatherType(
        weatherDescription = "Slight snow fall",
        weatherIcon = R.drawable.ic_snowy
    )
    object ModerateSnowFall: WeatherType(
        weatherDescription = "Moderate snow fall",
        weatherIcon = R.drawable.ic_heavysnow
    )
    object HeavySnowFall: WeatherType(
        weatherDescription = "Heavy snow fall",
        weatherIcon = R.drawable.ic_heavysnow
    )
    object SnowGrains: WeatherType(
        weatherDescription = "Snow grains",
        weatherIcon = R.drawable.ic_heavysnow
    )
    object SlightRainShowers: WeatherType(
        weatherDescription = "Slight rain showers",
        weatherIcon = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WeatherType(
        weatherDescription = "Moderate rain showers",
        weatherIcon = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WeatherType(
        weatherDescription = "Violent rain showers",
        weatherIcon = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WeatherType(
        weatherDescription = "Light snow showers",
        weatherIcon = R.drawable.ic_snowy
    )
    object HeavySnowShowers: WeatherType(
        weatherDescription = "Heavy snow showers",
        weatherIcon = R.drawable.ic_snowy
    )
    object ModerateThunderstorm: WeatherType(
        weatherDescription = "Moderate thunderstorm",
        weatherIcon = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WeatherType(
        weatherDescription = "Thunderstorm with slight hail",
        weatherIcon = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WeatherType(
        weatherDescription = "Thunderstorm with heavy hail",
        weatherIcon = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}
