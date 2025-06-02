package com.hanx.sunnyweathercompose.logic.model

data class DailyResponse(val code: String, val daily: List<Daily>)

data class Daily(
    val fxDate: String,
    val tempMax: String,
    val tempMin: String,
    val iconDay: String,
    val textDay: String,
    val iconNight: String,
    val textNight: String,
    val humidity: String
)
