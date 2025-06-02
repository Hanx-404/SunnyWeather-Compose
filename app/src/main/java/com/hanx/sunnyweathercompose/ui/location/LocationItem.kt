package com.hanx.sunnyweathercompose.ui.location

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanx.sunnyweathercompose.logic.model.Location
import com.hanx.sunnyweathercompose.ui.theme.SunnyWeatherTheme

@Composable
fun LocationItem(
    location: Location
) {
    Card(modifier = Modifier.padding(18.dp).fillMaxWidth().height(120.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            val fullName = "${location.country} ${location.adm2} ${location.name}"
            Text(
                text = location.name,
                fontSize = 26.sp
            )
            Text(
                text = fullName,
                fontSize = 20.sp,
            )
        }
    }
}

@Preview
@Composable
fun LocationItemPreview() {
   SunnyWeatherTheme {
       LocationItem(
           Location(
               name = "上海",
               id = "11",
               country = "中国",
               adm1 = "上海",
               adm2 = "上海"
           )
       )
   }
}