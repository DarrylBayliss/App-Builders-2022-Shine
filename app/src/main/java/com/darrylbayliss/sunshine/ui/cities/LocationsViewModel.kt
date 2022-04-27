package com.darrylbayliss.sunshine.ui.cities

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darrylbayliss.sunshine.domain.GetLocationNamesUseCase
import com.darrylbayliss.sunshine.domain.Location
import com.darrylbayliss.sunshine.domain.SaveLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    val getLocationNamesUseCase: GetLocationNamesUseCase,
    val saveLocationUseCase: SaveLocationUseCase
) :
    ViewModel() {

    val locations: MutableState<List<String>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            locations.value = getLocationNamesUseCase()
        }
    }

    fun saveLocation(location: Location) {
        viewModelScope.launch {
            saveLocationUseCase(location)
        }
    }
}
