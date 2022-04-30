package com.darrylbayliss.sunshine.domain

import java.io.Serializable

data class SelectedLocation(
    val id: String,
    val name: String,
    val temperature: Float,
    val highestTemperature: Float,
    val lowestTemperature: Float,
    val percipitationChance: Float,
    val sunrise: String,
    val sunset: String
) : Serializable
