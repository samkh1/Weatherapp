package com.sri.weatherapp.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sri.weatherapp.domain.WeatherState
import androidx.compose.foundation.layout.Row as Row

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListTempuratureScreen(
    state: WeatherState
) {
    when {
        !state.isError.isNullOrEmpty() -> EmptyScreen(state.isError)
        state.isLoading -> LoadingScreen()
        state.weatherData?.weathers?.isNotEmpty() == true -> {
            state.weatherData.weathers.get(0)?.let { weatherList ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .size(80.dp)
                        .fillMaxWidth()
                        .padding(all = 8.dp),

                    ) {
                    LazyColumn(horizontalAlignment = Alignment.Start) {
                        // Add a single item
                        stickyHeader {
                            TempItem("Hier", "20", "25")
                        }

                        items(weatherList) {
                            TempItem(
                                day = it.time.dayOfMonth.toString(),
                                maxtemp = it.temperatureCelsius.toString(),
                                minTemp = it.temperatureCelsius.toString(),
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun TempItem(day: String, maxtemp: String, minTemp: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = day, color = Color.White)
        Box {
            Row {
                Text(text = maxtemp, color = Color.White)
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = minTemp, color = Color.White)
            }
        }
    }
}


@Preview
@Composable
fun showHeader() {
    TempItem(day = "Today ", maxtemp = "23", minTemp = "20")
}
