package com.hanx.sunnyweathercompose.ui.weather

import androidx.compose.foundation.Image
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
import com.hanx.sunnyweathercompose.R
import com.hanx.sunnyweathercompose.logic.model.Daily
import com.hanx.sunnyweathercompose.ui.theme.SunnyWeatherTheme

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
        // val context = SunnyWeatherApplication.context
        // val resourceName = "ic_skycon_${daily.iconDay}"
        // val skyconResId = context.resources.getIdentifier(resourceName, "drawable", context.packageName)
        Text(
            text = daily.fxDate,
            modifier = Modifier.wrapContentHeight()
        )
        Icon(
            // painter = painterResource(skyconResId),
            painter = painterResource(R.drawable.ic_skycon_100_fill),
            contentDescription = "天气图标"
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

// @Composable
// fun Skycon(
//     icon: String,
//     modifier: Modifier = Modifier,
//     fontSize: TextUnit = 24.sp,
//     color: Color = Color.Black
// ) {
//     Text(
//         text = icon,
//         fontFamily = QWeatherIconFamily,
//         fontSize = fontSize,
//         color = color,
//         modifier = modifier
//     )
// }

@Preview(showBackground = true)
@Composable
fun DailyItemPreview() {
    SunnyWeatherTheme {
        DailyItem(
            daily = Daily(
                fxDate = "2023-03-01",
                tempMax = "10",
                tempMin = "5",
                iconDay = "100",
                textDay = "晴",
                iconNight = "100",
                textNight = "晴",
                humidity = "50"
            )
        )
    }
}
