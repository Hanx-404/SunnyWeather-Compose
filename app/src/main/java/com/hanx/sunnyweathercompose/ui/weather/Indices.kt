package com.hanx.sunnyweathercompose.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanx.sunnyweathercompose.SunnyWeatherApplication
import com.hanx.sunnyweathercompose.logic.model.IndicesDaily

@Composable
fun Indices(indices: List<IndicesDaily>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(4.dp))
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "生活指数",
                fontSize = 20.sp,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
            )
            // 0：洗车指数，1：穿衣指数，2：紫外线指数，3：感冒指数
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                IndicesItem(indices[0], Modifier.height(60.dp).weight(1f))
                IndicesItem(indices[1], Modifier.height(60.dp).weight(1f))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                IndicesItem(indices[2], Modifier.height(60.dp).weight(1f))
                IndicesItem(indices[3], Modifier.height(60.dp).weight(1f))
            }
        }
    }
}

@Composable
fun IndicesItem(indicesDaily: IndicesDaily, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        val indicesIcon = SunnyWeatherApplication.INDICES_ICON_MAP[indicesDaily.type]
        Image(
            painter = painterResource(indicesIcon!!),
            contentDescription = "${indicesDaily.name}图标",
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 15.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 15.dp)
        ) {
            Text(
                text = indicesDaily.name,
                fontSize = 12.sp,
                modifier = Modifier.wrapContentSize()
            )
            Text(
                text = indicesDaily.category,
                fontSize = 16.sp,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicesPreview() {
    val indices = listOf(
        IndicesDaily("2023-05-01", "2", "洗车指数", "一般"),
        IndicesDaily("2023-05-01", "3", "穿衣指数", "较冷"),
        IndicesDaily("2023-05-01", "5", "紫外线指数", "弱"),
        IndicesDaily("2023-05-01", "9", "感冒指数", "无")
    )
    Indices(indices)
}