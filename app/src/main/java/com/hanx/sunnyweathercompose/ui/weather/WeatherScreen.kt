package com.hanx.sunnyweathercompose.ui.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherScreen(weatherViewModel: WeatherViewModel = viewModel()) {
    val _weatherLiveData = weatherViewModel.weatherLiveData.observeAsState()
    val weatherLiveData by remember { _weatherLiveData }

    val nowWeather = weatherLiveData?.getOrNull()?.now
}