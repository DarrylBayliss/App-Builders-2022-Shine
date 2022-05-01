package com.darrylbayliss.sunshine.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darrylbayliss.sunshine.domain.GetSelectedLocationByIdUseCase
import com.darrylbayliss.sunshine.domain.SelectedLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val getSelectedLocationByIdUseCase: GetSelectedLocationByIdUseCase) :
    ViewModel() {

    var detailViewState by mutableStateOf(DetailViewState(null))

    fun getSelectedLocation(id: String) {
        viewModelScope.launch {
            val selectedLocation = getSelectedLocationByIdUseCase(id)
            detailViewState = DetailViewState(selectedLocation)
        }
    }
}

data class DetailViewState(val selectedLocation: SelectedLocation?)
