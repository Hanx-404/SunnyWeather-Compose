package com.hanx.sunnyweathercompose.logic

import androidx.lifecycle.liveData
import com.hanx.sunnyweathercompose.logic.dao.LocationDao
import com.hanx.sunnyweathercompose.logic.model.Location
import com.hanx.sunnyweathercompose.logic.model.Weather
import com.hanx.sunnyweathercompose.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

object Repository {

    fun searchLocations(location: String) = fire(Dispatchers.IO) {
        val locationResponse = SunnyWeatherNetwork.searchLocations(location)
        if (locationResponse.code == "200") {
            val locations = locationResponse.location
            Result.success(locations)
        } else {
            Result.failure(RuntimeException("response status code is ${locationResponse.code}"))
        }
    }

    fun refreshWeather(locationId: String) = fire(Dispatchers.IO) {
        coroutineScope {
            val deferredNow = async {
                SunnyWeatherNetwork.getNowWeather(locationId)
            }
            val deferredDaily = async {
                SunnyWeatherNetwork.getDailyWeather(locationId)
            }
            val deferredIndices = async {
                SunnyWeatherNetwork.getIndices(locationId)
            }
            val nowResponse = deferredNow.await()
            val dailyResponse = deferredDaily.await()
            val indicesResponse = deferredIndices.await()
            if (nowResponse.code == "200" && dailyResponse.code == "200" && indicesResponse.code == "200") {
                val weather =
                    Weather(nowResponse.now, dailyResponse.daily, indicesResponse.daily)
                Result.success(weather)
            } else {
                Result.failure(
                    RuntimeException(
                        "now response status code is ${nowResponse.code}" +
                                "daily response status code is ${dailyResponse.code}" +
                                "indices response status code is ${indicesResponse.code}"
                    )
                )
            }
        }
    }

    fun saveLocation(location: Location) = LocationDao.saveLocation(location)

    fun getSavedLocation() = LocationDao.getSavedLocation()

    fun isLocationSaved() = LocationDao.isLocationSaved()

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}

