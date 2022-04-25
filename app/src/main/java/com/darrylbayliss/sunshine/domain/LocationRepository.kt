package com.darrylbayliss.sunshine.domain

import com.darrylbayliss.sunshine.data.LocationDTO
import com.darrylbayliss.sunshine.data.LocationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationRepository(private val locationService: LocationService) {

    suspend fun getLocations(): List<LocationDTO> {
        return withContext(Dispatchers.IO) {
            locationService
                .getLocations()
        }
    }
}
