package com.hanx.sunnyweathercompose.logic

import androidx.lifecycle.liveData
import com.hanx.sunnyweathercompose.logic.model.Location
import com.hanx.sunnyweathercompose.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {

    fun searchLocations(location: String) = liveData(Dispatchers.IO) {
        val result = try {
            val locationResponse = SunnyWeatherNetwork.searchLocations(location)
            if (locationResponse.code == "200") {
                val locations = locationResponse.location
                Result.success(locations)
            } else {
                Result.failure(RuntimeException("response status code is ${locationResponse.code}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
        emit(result)
    }
}