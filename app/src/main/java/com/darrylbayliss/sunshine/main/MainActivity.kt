package com.darrylbayliss.sunshine.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darrylbayliss.sunshine.R
import com.darrylbayliss.sunshine.ui.theme.SunshineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SunshineTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Scaffold(
        topBar = { TopBar() },
        content = { WeatherList() }
    )
}

@Composable
fun TopBar() {
    TopAppBar(title = { Text("Shine") })
}

@Composable
fun WeatherList() {
    LazyColumn {
        items(listOf("Ascona", "London", "New York")) { weather ->
            WeatherCard(weather)
        }
    }
}

@Composable
fun WeatherCard(weather: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
            .border(BorderStroke(width = 0.1.dp, color = Color.Gray))
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_weather_sun),
                    contentDescription = "Weather Icon"
                )
                Text(weather)

                Image(
                    painter = painterResource(id = R.drawable.ic_sunrise),
                    contentDescription = "Sunrise"
                )
                Text("08:23")

                Image(
                    painter = painterResource(id = R.drawable.ic_sunset),
                    contentDescription = "Sunset"
                )
                Text("19:34")
            }

            Row {
                Text("14 degrees")
                Column {
                    Text("H:16")
                    Text("L:12")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherListPreview() {
    SunshineTheme {
        App()
    }
}
