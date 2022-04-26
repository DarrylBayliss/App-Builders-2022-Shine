package com.darrylbayliss.sunshine.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSelectedLocationsUseCase @Inject constructor(private val selectedLocationRepository: SelectedLocationRepository) {

    suspend operator fun invoke(): Flow<List<SelectedLocation>> {
        return selectedLocationRepository.selectedLocations()
    }
}
