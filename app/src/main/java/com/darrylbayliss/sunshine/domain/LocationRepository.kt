package com.darrylbayliss.sunshine.domain

import com.darrylbayliss.sunshine.data.LocationDTO
import com.darrylbayliss.sunshine.data.LocationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocationRepository @Inject constructor(private val locationService: LocationService) {

    suspend fun getLocations(): List<Location> {
        return withContext(Dispatchers.IO) {
            locationService
                .getLocations()
                .toLocations()
        }
    }

    private fun List<LocationDTO>.toLocations(): List<Location> {
        return map { locationDTO ->
            Location(
                id = locationDTO.id,
                name = locationDTO.name,
                temperature = locationDTO.temperature,
                highestTemperature = locationDTO.highestTemperature,
                lowestTemperature = locationDTO.lowestTemperature,
                sunrise = locationDTO.sunrise,
                sunset = locationDTO.sunset
            )
        }
    }
}
