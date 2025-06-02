package com.hanx.sunnyweathercompose.logic.model

data class Weather(val now: Now, val daily: List<Daily>, val indicesDaily: List<IndicesDaily>)
