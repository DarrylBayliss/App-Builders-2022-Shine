package com.darrylbayliss.sunshine.ui.locations

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darrylbayliss.sunshine.domain.GetLocationsUseCase
import com.darrylbayliss.sunshine.domain.Location
import com.darrylbayliss.sunshine.domain.SaveLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    val getLocationUseCase: GetLocationsUseCase,
    val saveLocationUseCase: SaveLocationUseCase
) :
    ViewModel() {

    val locations: MutableState<List<Location>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            locations.value = getLocationUseCase()
        }
    }

    fun saveLocation(location: Location) {
        viewModelScope.launch {
            saveLocationUseCase(location)
        }
    }
}
