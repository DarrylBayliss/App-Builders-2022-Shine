package com.darrylbayliss.sunshine.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darrylbayliss.sunshine.domain.GetSelectedLocationsUseCase
import com.darrylbayliss.sunshine.domain.SelectedLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val getSelectedLocationsUseCase: GetSelectedLocationsUseCase) :
    ViewModel() {

    val weather: MutableState<List<SelectedLocation>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            weather.value = getSelectedLocationsUseCase().first()
        }
    }
}
