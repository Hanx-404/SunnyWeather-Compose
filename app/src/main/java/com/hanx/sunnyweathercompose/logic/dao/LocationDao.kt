package com.hanx.sunnyweathercompose.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.hanx.sunnyweathercompose.SunnyWeatherApplication
import com.hanx.sunnyweathercompose.logic.model.Location

object LocationDao {

    fun saveLocation(location: Location) {
        sharedPreferences().edit {
            putString("location", Gson().toJson(location))
        }
    }

    fun getSavedLocation(): Location {
        val locationJson = sharedPreferences().getString("location", "");
        return Gson().fromJson(locationJson, Location::class.java)
    }

    fun isLocationSaved() = sharedPreferences().contains("location")

    private fun sharedPreferences() = SunnyWeatherApplication.context.
            getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}