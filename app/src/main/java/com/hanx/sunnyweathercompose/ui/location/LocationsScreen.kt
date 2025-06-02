package com.hanx.sunnyweathercompose.ui.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hanx.sunnyweathercompose.R
import com.hanx.sunnyweathercompose.logic.model.Location
import com.hanx.sunnyweathercompose.ui.theme.Purple40
import com.hanx.sunnyweathercompose.ui.theme.SunnyWeatherTheme

@Composable
fun LocationsScreen(
    modifier: Modifier = Modifier,
    locationViewModel: LocationViewModel = viewModel()
) {
    // val locationList = locationViewModel.locationLiveData.observeAsState()
    val locationLiveData = locationViewModel.locationLiveData.observeAsState()
    val locationList by remember { locationLiveData }
    var inputLocation by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg_place),
            contentDescription = "background image",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    // .height(60.dp)
                    .wrapContentHeight()
                    .background(Purple40)
                    // .align(Alignment.TopCenter)
            ) {
                SearchBar(
                    value = inputLocation,
                    onValueChange = { newValue ->
                        inputLocation = newValue
                        if (inputLocation.isNotEmpty()) {
                            locationViewModel.searchLocations(inputLocation)
                        } else {
                            locationViewModel.locationList.clear()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        // .height(20.dp)
                        // .align(Alignment.Center)
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                )
            }
            LocationResults(locationList)
        }
    }
}

@Composable
fun SearchBar(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = "请输入城市名")
        },
        modifier = modifier
    )
}

@Composable
fun LocationResults(locationList: Result<List<Location>>?) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        val locations = locationList?.getOrNull()
        locations?.let {
            items(it) { item ->
                LocationItem(location = item)
            }
        }
    }
}

// @Composable
// fun LocationItem(
//     location: Location
// ) {
//     Card(modifier = Modifier.padding(18.dp).fillMaxWidth().height(100.dp)) {
//         Column(
//             modifier = Modifier
//                 .fillMaxWidth()
//                 .wrapContentHeight()
//         ) {
//             val fullName = "${location.country} ${location.adm2} ${location.name}"
//             Text(
//                 text = location.name
//             )
//             Text(
//                 text = fullName
//             )
//         }
//     }
// }

@Preview(showBackground = true)
@Composable
fun LocationsScreenPreview() {
    SunnyWeatherTheme {
        Scaffold { innerPadding ->
            LocationsScreen(modifier = Modifier.padding(innerPadding))
            // LocationItem(modifier = Modifier.padding(innerPadding))
        }
    }
}