package com.darrylbayliss.sunshine.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
        startDestination = SunshineScreen.Main().name,
        modifier = modifier
    ) {
        composable(SunshineScreen.Main().name) {

            it.arguments?.putString(TITLE_BUNDLE_ARGUMENT, SunshineScreen.Main().name)
            MainScreen(
                viewModel = hiltViewModel(),
                onWeatherCardClicked = { selectedLocation ->
                    navigateToDetailScreen(navController, selectedLocation.id)
                }
            )
        }

        composable(SunshineScreen.Locations().name) {

            it.arguments?.putString(TITLE_BUNDLE_ARGUMENT, SunshineScreen.Locations().name)
            LocationsScreen(
                viewModel = hiltViewModel(),
                onLocationClicked = {
                    navigateToMainScreen(navController)
                }
            )
        }

        composable(
            route = "${SunshineScreen.Detail().name}/{selectedLocationId}}",
            arguments = listOf(navArgument("selectedLocationId") { type = NavType.StringType })
        ) { entry ->

            entry.arguments?.putString(TITLE_BUNDLE_ARGUMENT, SunshineScreen.Detail().name)
            val selectedLocationId = entry.arguments?.getString("selectedLocationId")

            if (selectedLocationId != null) {
                DetailScreen(
                    viewModel = hiltViewModel(),
                    selectedLocationId = selectedLocationId
                )
            } else {
                throw IllegalStateException("We should not get an null selectedLocationId")
            }
        }
    }
}

fun navigateToMainScreen(navController: NavHostController) {
    navController.navigate(SunshineScreen.Main().name)
}

fun navigateToLocationsScreen(navController: NavHostController) {
    navController.navigate(SunshineScreen.Locations().name)
}

fun navigateToDetailScreen(navController: NavHostController, id: String) {
    navController.navigate("${SunshineScreen.Detail().name}/$id}")
}

const val TITLE_BUNDLE_ARGUMENT = "title"
