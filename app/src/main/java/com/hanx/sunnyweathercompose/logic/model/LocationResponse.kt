package com.hanx.sunnyweathercompose.logic.model

data class LocationResponse(val code: String, val location: List<Location>)

data class Location(
    val name: String,
    val id: String,
    val country: String,
    val adm1: String,
    val adm2: String
)
