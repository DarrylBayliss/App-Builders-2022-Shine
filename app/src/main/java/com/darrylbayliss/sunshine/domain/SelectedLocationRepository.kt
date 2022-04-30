package com.darrylbayliss.sunshine.domain

import com.darrylbayliss.sunshine.data.LocationDTO
import com.darrylbayliss.sunshine.data.LocationService
import com.darrylbayliss.sunshine.data.SelectedLocationStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SelectedLocationRepository @Inject constructor(
    private val selectedLocationStore: SelectedLocationStore,
    private val locationService: LocationService
) {

    suspend fun selectedLocations(): Flow<List<SelectedLocation>> {
        return withContext(Dispatchers.IO) {
            combine(
                selectedLocationStore.selectedLocationIds(),
                flow { emit(locationService.getLocations()) }
            ) { selectedLocationIds, locations ->
                locations.filter { locationDTO ->
                    selectedLocationIds.contains(locationDTO.id)
                }.toSelectedLocations()
            }
        }
    }

    suspend fun saveLocation(location: Location) {
        return withContext(Dispatchers.IO) {
            selectedLocationStore.setSelectedLocationId(location.id, location.name)
        }
    }

    private fun List<LocationDTO>.toSelectedLocations(): List<SelectedLocation> {
        return map { locationDTO ->
            SelectedLocation(
                id = locationDTO.id,
                name = locationDTO.name,
                temperature = locationDTO.temperature,
                highestTemperature = locationDTO.highestTemperature,
                lowestTemperature = locationDTO.lowestTemperature,
                percipitationChance = locationDTO.percipitationChance,
                sunrise = locationDTO.sunrise,
                sunset = locationDTO.sunset
            )
        }
    }
}
