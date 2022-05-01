package com.darrylbayliss.sunshine.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelectedLocation(
    val id: String,
    val name: String,
    val temperature: Float,
    val highestTemperature: Float,
    val lowestTemperature: Float,
    val percipitationChance: Float,
    val sunrise: String,
    val sunset: String
) : Parcelable
