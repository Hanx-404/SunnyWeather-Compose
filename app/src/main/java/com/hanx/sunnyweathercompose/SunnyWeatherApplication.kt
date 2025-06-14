package com.hanx.sunnyweathercompose

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {

    companion object {
        // 和风天气 TOKEN
        const val TOKEN = "a3b692be61e54fa98dce71bdd74d5ce4"
        // 天气指数类型
        // 2：洗车指数，3：穿衣指数，5：紫外线指数，9：感冒指数
        const val INDICES_TYPE = "2,3,5,9"
        // 天气指数类型与其图标的映射
        val INDICES_ICON_MAP: Map<String, Int> = mapOf(
            "2" to R.drawable.ic_carwashing,
            "3" to R.drawable.ic_dressing,
            "5" to R.drawable.ic_ultraviolet,
            "9" to R.drawable.ic_coldrisk
        )

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}