package com.example.unidad6_eltiempo.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unidad6_eltiempo.R
import kotlinx.coroutines.launch


class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private lateinit var pbLoading: View
    private lateinit var rvWeather: RecyclerView
    private var adapter: WeatherAdapter? = null

    private val viewModel: WeatherViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvWeather = view.findViewById(R.id.rvWeather)
        pbLoading = view.findViewById(R.id.progressBar)
        initList()
        listenEvents()
        viewModel.getWeatherInfo()



    }

    private fun initList(){
        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvWeather.layoutManager = mLayoutManager
        adapter = WeatherAdapter()
        rvWeather.adapter = adapter
    }

    private fun listenEvents() {

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {
                    viewModel.weatherInfo.collect {
                        adapter?.data = listOf()
                        adapter?.notifyDataSetChanged()

                    }
                }
                launch {
                    viewModel.loading.collect {
                        pbLoading.isVisible = it
                    }
                }
            }
        }
    }





}

