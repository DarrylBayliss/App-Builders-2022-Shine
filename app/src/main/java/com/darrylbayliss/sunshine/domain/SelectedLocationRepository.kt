package com.darrylbayliss.sunshine.domain

import com.darrylbayliss.sunshine.data.LocationDTO
import com.darrylbayliss.sunshine.data.LocationService
import com.darrylbayliss.sunshine.data.SelectedLocationStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow

class SelectedLocationRepository(
    private val selectedLocationStore: SelectedLocationStore,
    private val locationService: LocationService
) {

    fun getSelectedLocations(): Flow<List<SelectedLocation>> {
        return combine(
            selectedLocationStore.getSelectedLocationIds(),
            flow { emit(locationService.getLocations()) }
        ) { selectedLocationIds, locations ->
            locations.toSelectedLocations().filter { selectedLocation ->
                selectedLocationIds.contains(selectedLocation.id)
            }
        }
    }

    private fun List<LocationDTO>.toSelectedLocations(): List<SelectedLocation> {
        return map { locationDTO ->
            SelectedLocation(
                id = locationDTO.id,
                name = locationDTO.name
            )
        }
    }
}
