package com.hanx.sunnyweathercompose.logic.network

import com.hanx.sunnyweathercompose.SunnyWeatherApplication
import com.hanx.sunnyweathercompose.logic.model.LocationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationService {

    @GET("geo/v2/city/lookup?key=${SunnyWeatherApplication.TOKEN}")
    fun searchLocation(@Query("location") location: String): Call<LocationResponse>
}