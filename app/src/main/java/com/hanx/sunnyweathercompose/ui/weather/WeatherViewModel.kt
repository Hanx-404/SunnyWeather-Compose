package com.hanx.sunnyweathercompose.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.hanx.sunnyweathercompose.logic.Repository

class WeatherViewModel : ViewModel() {

    private val locationIdLiveData = MutableLiveData<String>()

    val weatherLiveData = locationIdLiveData.switchMap { locationId ->
        Repository.refreshWeather(locationId)
    }

    fun refreshWeather(locationId: String) {
        locationIdLiveData.value = locationId
    }
}