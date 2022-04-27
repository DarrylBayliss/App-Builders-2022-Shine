package com.darrylbayliss.sunshine.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.darrylbayliss.sunshine.R
import com.darrylbayliss.sunshine.domain.SelectedLocation

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onClickWeatherDetail: () -> Unit
) {
    LazyColumn {
        items(viewModel.weather.value) { weather ->
            WeatherCard(weather)
        }
    }
}

@Composable
fun WeatherCard(weather: SelectedLocation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
            .border(BorderStroke(width = 0.1.dp, color = Color.Gray))
    ) {
        Column(
            modifier = Modifier
                .padding(top = 10.0.dp)
                .padding(horizontal = 6.0.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_weather_sun),
                    contentDescription = "Weather Icon"
                )
                Text(
                    text = weather.name
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_sunrise),
                    contentDescription = "Sunrise"
                )
                Text(
                    text = "08:23"
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_sunset),
                    contentDescription = "Sunset"
                )
                Text(
                    text = "19:34"
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier.size(width = 100.dp, height = 100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("14°c")
                }

                Box(
                    modifier = Modifier.size(width = 100.dp, height = 100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text("H:16°c")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("L:12°c")
                    }
                }
            }
        }
    }
}
