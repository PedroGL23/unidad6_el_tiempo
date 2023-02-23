package com.example.unidad6_eltiempo.data.remote

import layout.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

object ApiRest {
    lateinit var service: ApiService
    val URL = "https://api.openweathermap.org/data/2.5/"
    val appid = "814f55ba921ac8b791d64842b856ed89"
    val lang = "es"
    val latitude = "40.4167047"
    val longitude = "-3.7035825"
    val units = "metric"


    init{
        initService()
    }

    private fun initService(){
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory .create())
            .build()
        service = retrofit.create(ApiService::class.java)
    }


}

