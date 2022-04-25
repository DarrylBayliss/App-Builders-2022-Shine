package com.darrylbayliss.sunshine

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

class SunshineApplication : Application()

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "selectedWeatherlocations")
