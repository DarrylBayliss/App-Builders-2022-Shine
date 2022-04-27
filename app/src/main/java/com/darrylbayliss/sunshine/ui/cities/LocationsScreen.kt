package com.darrylbayliss.sunshine.ui.cities

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun LocationsScreen(viewModel: LocationsViewModel) {
    LazyColumn {
        items(viewModel.locations.value) { location ->
            LocationCard(location)
        }
    }
}

@Composable
fun LocationCard(location: String) {
}
