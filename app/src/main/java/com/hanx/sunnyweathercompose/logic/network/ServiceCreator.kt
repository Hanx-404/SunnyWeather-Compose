package com.hanx.sunnyweathercompose.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceCreator {

    private const val API_HOST = "https://kw487qu4gc.re.qweatherapi.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}