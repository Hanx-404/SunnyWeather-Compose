package com.hanx.sunnyweathercompose.logic.network

import com.hanx.sunnyweathercompose.SunnyWeatherApplication
import com.hanx.sunnyweathercompose.logic.model.DailyResponse
import com.hanx.sunnyweathercompose.logic.model.IndicesResponse
import com.hanx.sunnyweathercompose.logic.model.NowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("v7/weather/now?key=${SunnyWeatherApplication.TOKEN}")
    fun getNowWeather(@Query("location") locationId: String): Call<NowResponse>

    @GET("v7/weather/7d?key=${SunnyWeatherApplication.TOKEN}")
    fun getDailyWeather(@Query("location") locationId: String): Call<DailyResponse>

    @GET("v7/indices/1d?type=${SunnyWeatherApplication.INDICES_TYPE}&key=${SunnyWeatherApplication.TOKEN}")
    fun getIndices(@Query("location") locationId: String): Call<IndicesResponse>
}