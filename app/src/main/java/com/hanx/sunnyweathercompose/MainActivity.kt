package com.hanx.sunnyweathercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hanx.sunnyweathercompose.ui.location.LocationsScreen
import com.hanx.sunnyweathercompose.ui.theme.SunnyWeatherTheme
import com.hanx.sunnyweathercompose.ui.weather.WeatherScreen
import com.hanx.sunnyweathercompose.ui.weather.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SunnyWeatherTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation(weatherViewModel: WeatherViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "locations") {
        composable("locations") {
            LocationsScreen(navController)
        }
        composable("weather/{locationId}/{locationName}") { backStackEntry ->
            val locationId = backStackEntry.arguments?.getString("locationId")
            val locationName = backStackEntry.arguments?.getString("locationName")
            if (locationId != null && locationName != null) {
                // weatherViewModel.refreshWeather(locationId)
                WeatherScreen(locationId, locationName, navController)
            }
        }
    }

}