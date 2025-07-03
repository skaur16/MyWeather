package com.example.myweather.features.comp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myweather.features.weatherViewModel

@Composable
fun WeatherCard(viewModel: weatherViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f) // Occupies 40% of screen height (adjust as needed)
            .padding(10.dp),
       colors = CardDefaults.cardColors(
           containerColor = colorResource(id = com.example.myweather.R.color.primary),
       )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

                val temp =  viewModel.weatherInfo.value?.main?.temp!! - 273.15
                val formattedTemp = String.format("%.2f", temp)
                Text(" ${viewModel.weatherInfo.value?.main?.temp}°C",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 48.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(10.dp))
                //Text("Clouds: ${viewModel.weatherInfo.value?.clouds}%")
                //display icon image here

                val iconCode = viewModel.weatherInfo.value?.weather?.get(0)?.icon
                val iconUrl = "https://openweathermap.org/img/wn/${iconCode}@2x.png"

                AsyncImage(
                    model = iconUrl,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )

            Row(modifier = Modifier.align(CenterHorizontally)) {
                Text(text = viewModel.weatherInfo.value?.weather?.get(0)?.description ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp,
                    color = Color.White
                    )
            }
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text("Humidity: ${viewModel.weatherInfo.value?.main?.humidity}%",
                fontSize = 20.sp,
                color = Color.White
            )
            val windSpeed = viewModel.weatherInfo.value?.wind?.speed!! * 3.6
            val formattedWindSpeed = String.format("%.2f", windSpeed)
            Text("Wind Speed: $formattedWindSpeed km/h",
                fontSize = 20.sp,
                color = Color.White
                )

            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Weather Update for ${viewModel.locationText.value}",
                fontSize = 15.sp,
                color = Color.White
                )
        }
    }

}
