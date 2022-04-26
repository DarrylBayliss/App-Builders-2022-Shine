package com.darrylbayliss.sunshine.data

import retrofit2.http.GET

interface LocationService {

    @GET("sunshine/weather.json")
    suspend fun getLocations(): List<LocationDTO>
}
