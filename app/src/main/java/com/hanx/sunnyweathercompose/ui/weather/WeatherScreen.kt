package com.hanx.sunnyweathercompose.ui.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.hanx.sunnyweathercompose.logic.model.Daily
import com.hanx.sunnyweathercompose.logic.model.IndicesDaily
import com.hanx.sunnyweathercompose.logic.model.Now
import com.hanx.sunnyweathercompose.ui.theme.SunnyWeatherTheme

@Composable
fun WeatherScreen(
    locationId: String? = null,
    locationName: String = "城市名",
    navController: NavController,
    weatherViewModel: WeatherViewModel = viewModel()
) {
    locationId?.let {
        weatherViewModel.refreshWeather(it)
    }

    val _weatherLiveData = weatherViewModel.weatherLiveData.observeAsState()
    val weatherLiveData by remember { _weatherLiveData }

    val nowWeather = weatherLiveData?.getOrNull()?.now
    val dailyWeather = weatherLiveData?.getOrNull()?.daily
    val indices = weatherLiveData?.getOrNull()?.indicesDaily

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
    ) {
        if (nowWeather != null && dailyWeather != null && indices != null) {
            NowWeather(nowWeather, locationName) {
                navController.navigate("locations")
            }
            DailyWeather(dailyWeather)
            Indices(indices)
        } else {
            Text(text = "获取天气信息失败")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    val nowWeather = Now(
        "25",
        "15",
        "100",
        "晴",
        "北风",
        "3",
        "40"
    )
    val dailyWeather = List(7) {
        Daily(
            fxDate = "2023-03-01",
            tempMax = "10",
            tempMin = "5",
            iconDay = "101",
            textDay = "多云",
            iconNight = "100",
            textNight = "多云",
            humidity = "50"
        )
    }
    val indices = listOf(
        IndicesDaily("2023-05-01", "2", "洗车", "一般"),
        IndicesDaily("2023-05-01", "3", "穿衣", "较冷"),
        IndicesDaily("2023-05-01", "5", "紫外线", "弱"),
        IndicesDaily("2023-05-01", "6", "感冒", "无")
    )
    SunnyWeatherTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState())
        ) {
            NowWeather(nowWeather, "北京") {}
            DailyWeather(dailyWeather)
            Indices(indices)
        }
    }
}