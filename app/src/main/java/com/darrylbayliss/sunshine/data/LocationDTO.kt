package com.darrylbayliss.sunshine.data

data class LocationDTO(
    val id: String,
    val name: String,
    val temperature: Float,
    val highestTemperature: Float,
    val lowestTemperature: Float,
    val percipitationChance: Float,
    val sunrise: String,
    val sunset: String
)
