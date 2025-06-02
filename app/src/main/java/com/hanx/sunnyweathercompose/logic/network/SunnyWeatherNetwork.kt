package com.hanx.sunnyweathercompose.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {

    private val locationService = ServiceCreator.create<LocationService>()
    private val weatherService = ServiceCreator.create<WeatherService>()

    suspend fun searchLocations(locationId: String) = locationService.searchLocation(locationId).await()
    suspend fun getNowWeather(locationId: String) = weatherService.getNowWeather(locationId).await()
    suspend fun getDailyWeather(locationId: String) = weatherService.getDailyWeather(locationId).await()
    suspend fun getIndices(locationId: String) = weatherService.getIndices(locationId).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}