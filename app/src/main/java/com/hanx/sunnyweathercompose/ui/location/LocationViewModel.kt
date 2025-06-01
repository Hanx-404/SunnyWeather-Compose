package com.hanx.sunnyweathercompose.ui.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.hanx.sunnyweathercompose.logic.Repository
import com.hanx.sunnyweathercompose.logic.model.Location

class LocationViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val locationList = ArrayList<Location>()

    val locationLiveData = searchLiveData.switchMap { location ->
        Repository.searchLocations(location)
    }

    fun searchLocations(location: String) {
        searchLiveData.value = location
    }
}