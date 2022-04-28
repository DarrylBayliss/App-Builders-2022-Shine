package com.darrylbayliss.sunshine.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.darrylbayliss.sunshine.ui.SunshineScreen
import com.darrylbayliss.sunshine.ui.detail.DetailScreen
import com.darrylbayliss.sunshine.ui.locations.LocationsScreen
import com.darrylbayliss.sunshine.ui.main.MainScreen

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = SunshineScreen.Main.toString(),
        modifier = modifier
    ) {
        composable(SunshineScreen.Main.toString()) {
            MainScreen(
                viewModel = hiltViewModel(),
                onWeatherCardClicked = { navigateToDetailScreen(navController) }
            )
        }

        composable(SunshineScreen.Locations.toString()) {
            LocationsScreen(
                viewModel = hiltViewModel(),
                onLocationClicked = {
                    navigateToMainScreen(navController)
                }
            )
        }

        composable(SunshineScreen.Detail.toString()) {
            DetailScreen()
        }
    }
}

fun navigateToMainScreen(navController: NavHostController) {
    navController.navigate(SunshineScreen.Main.toString())
}

fun navigateToLocationsScreen(navController: NavHostController) {
    navController.navigate(SunshineScreen.Locations.toString())
}

fun navigateToDetailScreen(navController: NavHostController) {
    navController.navigate(SunshineScreen.Detail.toString())
}
