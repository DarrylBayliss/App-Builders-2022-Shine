package com.darrylbayliss.sunshine.domain

import javax.inject.Inject

class SaveLocationUseCase @Inject constructor(private val locationRepository: SelectedLocationRepository) {

    suspend operator fun invoke(location: Location) {
        locationRepository.saveLocation(location)
    }
}
