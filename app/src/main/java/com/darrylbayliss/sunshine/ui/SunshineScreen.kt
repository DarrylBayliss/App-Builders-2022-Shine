package com.darrylbayliss.sunshine.ui

sealed class SunshineScreen {
    data class Main(val name: String = "Shine") : SunshineScreen()
    data class Locations(val name: String = "Locations") : SunshineScreen()
    data class Detail(val name: String = "Detail") : SunshineScreen()
}
