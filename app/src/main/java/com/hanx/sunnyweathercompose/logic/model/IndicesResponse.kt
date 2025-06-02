package com.hanx.sunnyweathercompose.logic.model

data class IndicesResponse(val code: String, val daily: List<IndicesDaily>)

data class IndicesDaily(
    val date: String,
    val type: String,
    val name: String,
    val category: String
)
