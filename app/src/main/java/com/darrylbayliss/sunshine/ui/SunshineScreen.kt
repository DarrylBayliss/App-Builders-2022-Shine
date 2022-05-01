package com.darrylbayliss.sunshine.ui

sealed class SunshineScreen {
    data class Main(val name: String = "main") : SunshineScreen()
    data class Locations(val name: String = "locations") : SunshineScreen()
    data class Detail(val name: String = "detail") : SunshineScreen()
}
