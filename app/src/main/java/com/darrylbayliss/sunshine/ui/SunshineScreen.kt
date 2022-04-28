package com.darrylbayliss.sunshine.ui

sealed class SunshineScreen() {
    object Main : SunshineScreen()
    object Locations : SunshineScreen()
    object Detail : SunshineScreen()
}
