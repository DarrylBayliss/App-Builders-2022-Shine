package com.darrylbayliss.sunshine.domain

class SaveLocationUseCase(private val locationRepository: SelectedLocationRepository) {

    suspend operator fun invoke(location: Location) {
        locationRepository.saveLocation(location)
    }
}
