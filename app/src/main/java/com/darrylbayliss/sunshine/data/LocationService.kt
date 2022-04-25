package com.darrylbayliss.sunshine.data

import retrofit2.http.GET

interface LocationService {

    @GET("")
    suspend fun getLocations(): List<LocationDTO>
}
