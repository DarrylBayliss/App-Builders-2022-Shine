package com.darrylbayliss.sunshine.domain

data class SelectedLocation(
    val id: String,
    val name: String,
    val temperature: Float,
    val highestTemperature: Float,
    val lowestTemperature: Float,
    val sunrise: String,
    val sunset: String
)
