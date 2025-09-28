package com.hanx.sunnyweathercompose.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanx.sunnyweathercompose.R
import com.hanx.sunnyweathercompose.logic.model.Now
import com.hanx.sunnyweathercompose.logic.model.getSky
import com.hanx.sunnyweathercompose.ui.theme.SunnyWeatherTheme

@Composable
fun NowWeather(now: Now, locationName: String, onClick: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(530.dp)
    ) {
        Image(
            painter = painterResource(getSky(now.icon).bgResId),
            contentDescription = "实时天气背景图",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                IconButton(
                    onClick = onClick,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 15.dp)
                        .align(Alignment.TopStart)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_home),
                        contentDescription = "切换城市",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Text(
                    text = locationName,
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 60.dp, end = 60.dp)
                        .align(Alignment.TopCenter)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = "${now.temp}℃",
                    fontSize = 70.sp,
                    color = Color.White,
                    modifier = Modifier.wrapContentSize()
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 20.dp)
                ) {
                    Text(
                        text = "${now.text} | 体感 ${now.feelsLike}℃",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.wrapContentSize()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NowWeatherPreview() {
    SunnyWeatherTheme {
        NowWeather(
            Now(
                "25",
                "15",
                "100",
                "晴",
                "北风",
                "3",
                "40"
            ),
            "北京",
            onClick = { }
        )
    }
}