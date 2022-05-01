package com.darrylbayliss.sunshine.domain

import javax.inject.Inject

class GetSelectedLocationByIdUseCase @Inject constructor(private val selectedLocationRepository: SelectedLocationRepository) {

    suspend operator fun invoke(id: String): SelectedLocation {
        return selectedLocationRepository.getSelectedLocation(id)
    }
}
