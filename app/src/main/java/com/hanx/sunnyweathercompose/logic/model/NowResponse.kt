package com.hanx.sunnyweathercompose.logic.model

data class NowResponse(val code: String, val now: Now)

data class Now(
    val temp: String,
    val feelsLike: String,
    val icon: String,
    val text: String,
    val windDir: String,
    val windScale: String,
    val humidity: String
)
