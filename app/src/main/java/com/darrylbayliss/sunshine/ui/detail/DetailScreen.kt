package com.darrylbayliss.sunshine.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
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
import com.darrylbayliss.sunshine.ui.theme.SunshineTheme

@Composable
fun DetailScreen(selectedLocationId: String?) {
    SunshineTheme {
        WeatherDetail()
    }
}

@Composable
fun WeatherDetail() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp)
                .size(200.dp, 200.dp),
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = "Weather Detail Symbol"
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            CurrentTemperatureBox()
            HighLowTemperatureBox()
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.0.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SunsetSunriseTemperatureBox()
            PrecipitationChanceBox()
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CurrentTemperatureBox() {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .border(BorderStroke(width = 2.0.dp, color = Color.Black)),
        contentAlignment = Alignment.Center
    ) {
        Text(fontSize = TextUnit(value = 48.0F, TextUnitType.Sp), text = "14")
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun HighLowTemperatureBox() {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .border(BorderStroke(width = 2.0.dp, color = Color.Black)),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "H:16°c", fontSize = TextUnit(value = 24.0F, TextUnitType.Sp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "L:12°c", fontSize = TextUnit(value = 24.0F, TextUnitType.Sp))
        }
    }
}

@Composable
fun SunsetSunriseTemperatureBox() {
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
                    text = "08:23"
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
                    text = "19:34"
                )
            }
        }
    }
}

@Composable
fun PrecipitationChanceBox() {
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
                painter = painterResource(id = R.drawable.ic_sunset),
                contentDescription = "Sunset"
            )
            Text(
                text = "19:34"
            )
        }
    }
}
