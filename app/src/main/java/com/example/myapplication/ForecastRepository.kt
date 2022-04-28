package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ForecastRepository {

    private val _weeklyForecast = MutableLiveData<List<DailyForecast>>()
    val weeklyForecast: LiveData<List<DailyForecast>> = _weeklyForecast

    fun loadForecast(zipcode: String){
        val randomValues= List(7) { Random.nextFloat().rem(100) * 100 }
        val forecastItems = randomValues.map {temp ->
            DailyForecast(temp, description = "Partly Cloudy")
        }
            _weeklyForecast.setValue(forecastItems)
    }
}