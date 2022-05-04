package com.darrylbayliss.sunshine.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.darrylbayliss.sunshine.R
import com.darrylbayliss.sunshine.domain.SelectedLocation
import com.darrylbayliss.sunshine.ui.theme.SunshineTheme

@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    selectedLocationId: String
) {
    SunshineTheme {
        WeatherDetail(selectedLocation = viewModel.detailViewState.selectedLocation)
    }

    viewModel.getSelectedLocation(selectedLocationId)
}

@Composable
fun WeatherDetail(selectedLocation: SelectedLocation?) {

    if (selectedLocation == null) {
        FailureMessage()
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
                    .size(200.dp, 200.dp),
                painter = if (selectedLocation.temperature >= 15.0) {
                    painterResource(id = R.drawable.ic_weather_sun)
                } else {
                    painterResource(id = R.drawable.ic_weather_cold)
                },
                contentDescription = "Weather Detail Symbol"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CurrentTemperatureBox(selectedLocation.temperature)
                HighLowTemperatureBox(
                    selectedLocation.lowestTemperature,
                    selectedLocation.highestTemperature
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.0.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SunsetSunriseTemperatureBox(
                    sunriseTime = selectedLocation.sunrise,
                    sunsetTime = selectedLocation.sunset
                )
                PrecipitationChanceBox(percipitationChance = selectedLocation.percipitationChance)
            }
        }
    }
}

@Composable
fun FailureMessage() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.fillMaxSize(0.5f),
            painter = painterResource(id = R.drawable.ic_weather_rain),
            contentDescription = "No locations selected"
        )
        Text(
            text = "Oops. We couldn't load the weather for this login."
        )
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CurrentTemperatureBox(temperature: Float) {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .border(BorderStroke(width = 2.0.dp, color = Color.Black)),
        contentAlignment = Alignment.Center
    ) {
        Text(fontSize = TextUnit(value = 24.0F, TextUnitType.Sp), text = "$temperature°c")
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun HighLowTemperatureBox(
    highestTemperature: Float,
    lowestTemperature: Float
) {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .border(BorderStroke(width = 2.0.dp, color = Color.Black)),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "H: $highestTemperature°c",
                fontSize = TextUnit(value = 20.0F, TextUnitType.Sp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "L: $lowestTemperature°c",
                fontSize = TextUnit(value = 20.0F, TextUnitType.Sp)
            )
        }
    }
}

@Composable
fun SunsetSunriseTemperatureBox(
    sunriseTime: String,
    sunsetTime: String
) {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .border(BorderStroke(width = 2.0.dp, color = Color.Black)),
        contentAlignment = Alignment.Center
    ) {

        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sunrise),
                    contentDescription = "Sunrise"
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = sunriseTime
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sunset),
                    contentDescription = "Sunset"
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = sunsetTime
                )
            }
        }
    }
}

@Composable
fun PrecipitationChanceBox(percipitationChance: Float) {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .border(BorderStroke(width = 2.0.dp, color = Color.Black)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_weather_rain),
                contentDescription = "Sunset"
            )
            Text(
                modifier = Modifier.padding(start = 6.dp),
                text = "$percipitationChance%"
            )
        }
    }
}
