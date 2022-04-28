package com.darrylbayliss.sunshine.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.darrylbayliss.sunshine.ui.navigation.Navigation
import com.darrylbayliss.sunshine.ui.navigation.navigateToLocationsScreen
import com.darrylbayliss.sunshine.ui.theme.SunshineTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    SunshineTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopBar {
                    navigateToLocationsScreen(navController)
                }
            },
            content = { innerPadding ->
                Navigation(navController = navController, modifier = Modifier.padding(innerPadding))
            }
        )
    }
}

@Composable
fun TopBar(
    onAddLocationButtonClicked: () -> Unit
) {
    TopAppBar(
        title = { Text("Shine") },
        actions = {
            IconButton(
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Location"
                    )
                },
                onClick = { onAddLocationButtonClicked() }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun WeatherListPreview() {
    SunshineTheme {
        App()
    }
}
