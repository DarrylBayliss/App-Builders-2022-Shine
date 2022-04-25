package com.darrylbayliss.sunshine.domain

import com.darrylbayliss.sunshine.data.LocationDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetLocationsUseCase(private val locationRepository: LocationRepository) {

    suspend operator fun invoke() {
        return withContext(Dispatchers.IO) {
            locationRepository
                .getLocations()
                .toLocations()
        }
    }

    private fun List<LocationDTO>.toLocations() {
        map { locationDTO ->
            Location(locationDTO.name)
        }
    }
}
