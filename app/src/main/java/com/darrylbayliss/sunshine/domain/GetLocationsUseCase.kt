package com.darrylbayliss.sunshine.domain

import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(private val locationRepository: LocationRepository) {

    suspend operator fun invoke(): List<Location> {
        return locationRepository
            .getLocations()
    }
}
