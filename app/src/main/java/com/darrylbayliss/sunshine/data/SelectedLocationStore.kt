package com.darrylbayliss.sunshine.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.darrylbayliss.sunshine.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SelectedLocationStore(private val context: Context) {

    fun getSelectedLocationIds(): Flow<Set<String>> {
        return context.dataStore.data.map { ids ->
            ids.asMap().values as Set<String>
        }
    }

    suspend fun setSelectedLocationId(id: String, name: String) {
        context.dataStore.edit { ids ->
            val preferencesKey = stringPreferencesKey(name)
            ids[preferencesKey] = id
        }
    }
}
