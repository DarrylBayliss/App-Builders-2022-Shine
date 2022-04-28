package com.darrylbayliss.sunshine.ui.locations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darrylbayliss.sunshine.domain.Location
import com.darrylbayliss.sunshine.ui.theme.SunshineTheme

@Composable
fun LocationsScreen(
    viewModel: LocationsViewModel,
    onLocationClicked: () -> Unit
) {
    SunshineTheme {
        LocationsList(
            locations = viewModel.locations.value,
            onLocationRowClicked = { selectedLocation ->
                viewModel.saveLocation(location = selectedLocation)
                onLocationClicked()
            }
        )
    }
}

@Composable
fun LocationsList(
    locations: List<Location>,
    onLocationRowClicked: (Location) -> Unit
) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(locations) { location ->
            LocationRow(
                location = location,
                onLocationClicked = { locationName ->
                    onLocationRowClicked(locationName)
                }
            )
        }
    }
}

@Composable
fun LocationRow(
    location: Location,
    onLocationClicked: (Location) -> Unit
) {
    Text(
        modifier = Modifier
            .padding(all = 10.dp)
            .clickable { onLocationClicked(location) },
        text = location.name
    )
}

@Preview(showBackground = true)
@Composable
fun LocationsPreview() {
    SunshineTheme {
        LocationsList(locations = listOf(), {})
    }
}
