package com.example.unidad6_eltiempo.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unidad6_eltiempo.data.models.WeatherResponse
import com.example.unidad6_eltiempo.data.remote.ApiRest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    val weatherInfo = MutableStateFlow(listOf<WeatherResponse.Weather>())
    val loading = MutableStateFlow(false)

    fun getWeatherInfo(){
        loading.value = true

        viewModelScope.launch{
            val response = ApiRest.service.getWeatherInfo()
            if(response.isSuccessful && response.body() != null){
                weatherInfo.value = response.body()!!.weather!!
            }else{
                Log.i("WeatherViewModel", "getWeatherInfo: ${response.errorBody()?.string()}")
            }
            loading.value = false
        }

    }



}