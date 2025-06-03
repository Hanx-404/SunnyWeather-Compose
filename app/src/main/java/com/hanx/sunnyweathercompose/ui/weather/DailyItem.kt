package com.hanx.sunnyweathercompose.ui.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanx.sunnyweathercompose.logic.model.Daily
import com.hanx.sunnyweathercompose.logic.model.getSky
import com.hanx.sunnyweathercompose.ui.theme.Purple40
import com.hanx.sunnyweathercompose.ui.theme.SunnyWeatherTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DailyItem(daily: Daily) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(15.dp)
    ) {
        val date = LocalDate.parse(daily.fxDate)
        val dateFormatter = DateTimeFormatter.ofPattern("MM月dd日")
        val formattedDate = date.format(dateFormatter)
        Text(
            text = formattedDate,
            modifier = Modifier.wrapContentHeight()
        )
        Icon(
            painter = painterResource(getSky(daily.iconDay).iconResId),
            contentDescription = "天气图标",
            tint = Purple40
        )
        Text(
            text = daily.textDay,
            modifier = Modifier.wrapContentHeight()
        )
        Text(
            text = "${daily.tempMin} ~ ${daily.tempMax}℃",
            modifier = Modifier.wrapContentHeight()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DailyItemPreview() {
    SunnyWeatherTheme {
        DailyItem(
            daily = Daily(
                fxDate = "2023-03-01",
                tempMax = "10",
                tempMin = "5",
                iconDay = "101",
                textDay = "多云",
                iconNight = "100",
                textNight = "多云",
                humidity = "50"
            )
        )
    }
}
