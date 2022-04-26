package com.darrylbayliss.sunshine.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.darrylbayliss.sunshine.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SelectedLocationStore @Inject constructor(@ApplicationContext private val context: Context) {

    fun selectedLocationIds(): Flow<Set<String>> {
        return context.dataStore.data.map { ids ->
            ids.asMap().values.map { locationId ->
                locationId.toString()
            }.toSet()
        }
    }

    suspend fun setSelectedLocationId(id: String, name: String) {
        context.dataStore.edit { ids ->
            val preferencesKey = stringPreferencesKey(name)
            ids[preferencesKey] = id
        }
    }
}
