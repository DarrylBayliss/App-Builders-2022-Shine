package com.darrylbayliss.sunshine.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darrylbayliss.sunshine.domain.GetLocationsUseCase
import com.darrylbayliss.sunshine.domain.SelectedLocation
import kotlinx.coroutines.launch

class MainViewModel(val getLocationsUseCase: GetLocationsUseCase) : ViewModel() {

    val weather: MutableState<List<SelectedLocation>> = mutableStateOf(listOf())

    fun getSelectedLocations() {
        viewModelScope.launch {

        }
    }
}
