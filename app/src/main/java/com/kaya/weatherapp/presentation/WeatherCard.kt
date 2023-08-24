package com.kaya.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kaya.weatherapp.R
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun WeatherCard (
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeather?.let { data ->
        Card(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(0.dp,0.dp , 32.dp,32.dp),
            ) {
            Box (
                modifier = modifier
                    .background(brush = Brush.verticalGradient(
                        startY = 0.1F,
                        endY= 0.9F,
                        colors = listOf(Color(0xB837E1F1),
                            Color(0x783F65EB)
                        )
                    ))
            ){
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .fillMaxWidth()
                ) {

                    Spacer(modifier = Modifier.height(40.dp))
                    Image(
                        painter = painterResource(id = data.weatherType.weatherIcon),
                        contentDescription = null,
                        modifier = Modifier
                            .width(100.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "${data.temperatureCelsius}°C",
                        fontSize = 42.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = data.weatherType.weatherDescription,
                        textAlign = TextAlign.Center,
                        color = Color.White, fontSize = 22.sp
                    )
                    Text(
                        text = "Today, ${data.time.format(DateTimeFormatter.ofPattern("dd/MM"))}",
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                    Divider(thickness = 1.dp, color = Color.LightGray)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        WeatherDataDisplay(
                            value = data.pressure.roundToInt(),
                            unit = "hpa",
                            icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                            iconTint = Color.White,
                            textStyle = TextStyle(color = Color.White),
                        )
                        WeatherDataDisplay(
                            value = data.humidity.roundToInt(),
                            unit = "%",
                            icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                            iconTint = Color.White,
                            textStyle = TextStyle(color = Color.White),
                        )
                        WeatherDataDisplay(
                            value = data.windSpeed.roundToInt(),
                            unit = "km/h",
                            icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                            iconTint = Color.White,
                            textStyle = TextStyle(color = Color.White),
                        )
                    }
                }
            }
        }
    }
}