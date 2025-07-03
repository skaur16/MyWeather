package com.example.myweather.features.comp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myweather.features.weatherViewModel

@Composable
fun SearchLocation(viewModel : weatherViewModel) {

    Box(
        modifier = Modifier.padding(20.dp)
    ) {
        OutlinedTextField(
            value = viewModel.locationText.value,
            onValueChange = {
                viewModel.locationText.value = it
            },
            label = {Text(text = "Location")},
            placeholder = {
                Text (text = "City, Country",
                    color = Color.Gray)
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
        )


    }
}