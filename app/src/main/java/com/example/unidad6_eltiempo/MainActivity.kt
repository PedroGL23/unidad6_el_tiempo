package com.example.unidad6_eltiempo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unidad6_eltiempo.weather.WeatherFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager?.beginTransaction()?.replace(R.id.container, WeatherFragment())?.commit()
    }
}