package com.hanx.sunnyweathercompose.ui.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanx.sunnyweathercompose.logic.model.Daily

@Composable
fun DailyWeather(daily: List<Daily>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(4.dp))
            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "预报",
                fontSize = 20.sp,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 15.dp, top = 20.dp, bottom = 20.dp)
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
                repeat(7) {
                    DailyItem(daily[it])
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DailyWeatherPreview() {
    val dailyList = List(7) {
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
    DailyWeather(dailyList)
}
