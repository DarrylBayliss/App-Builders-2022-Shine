package com.darrylbayliss.sunshine.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darrylbayliss.sunshine.R
import com.darrylbayliss.sunshine.domain.SelectedLocation
import com.darrylbayliss.sunshine.ui.locations.LocationsList
import com.darrylbayliss.sunshine.ui.theme.SunshineTheme

@Composable
fun MainScreen(viewModel: MainViewModel, onWeatherCardClicked: (SelectedLocation) -> Unit) {
    SelectedLocations(viewModel.weather.value) { selectedLocation ->
        onWeatherCardClicked(selectedLocation)
    }
}

@Composable
fun SelectedLocations(
    selectedLocations: List<SelectedLocation>,
    onWeatherCardClicked: (SelectedLocation) -> Unit
) {

    if (selectedLocations.isNotEmpty()) {
        LazyColumn {
            items(items = selectedLocations) { selectedLocation ->
                WeatherCard(selectedLocation) { clickedLocation ->
                    onWeatherCardClicked(clickedLocation)
                }
            }
        }
    } else {
        EmptyList()
    }
}

@Composable
fun EmptyList() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.fillMaxSize(0.5f),
            painter = painterResource(id = R.drawable.ic_weather_sun),
            contentDescription = "No locations selected",
            colorFilter = ColorFilter.tint(color = LocalContentColor.current)
        )
        Text(
            text = "Add a location to see the weather here"
        )
    }
}

@Composable
fun WeatherCard(
    weather: SelectedLocation,
    onWeatherCardClicked: (SelectedLocation) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
            .border(BorderStroke(width = 0.1.dp, color = Color.Gray))
            .clickable { onWeatherCardClicked(weather) }
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
                    contentDescription = "Weather Icon",
                    colorFilter = ColorFilter.tint(color = LocalContentColor.current)
                )
                Text(
                    text = weather.name
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_sunrise),
                    contentDescription = "Sunrise"
                )
                Text(
                    text = weather.sunrise
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_sunset),
                    contentDescription = "Sunset",
                    colorFilter = ColorFilter.tint(color = LocalContentColor.current)
                )
                Text(
                    text = weather.sunset
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
                    Text("${weather.temperature}°c")
                }

                Box(
                    modifier = Modifier.size(width = 100.dp, height = 100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text("H:${weather.highestTemperature}°c")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("L:${weather.lowestTemperature}°c")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationsListPreview() {
    SunshineTheme {
        LocationsList(locations = listOf()) {}
    }
}
