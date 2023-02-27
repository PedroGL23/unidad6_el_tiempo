package com.example.unidad6_eltiempo.weather

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.unidad6_eltiempo.R
import com.example.unidad6_eltiempo.data.models.WeatherResponse


class WeatherAdapter(var data: List<WeatherResponse> = listOf() ) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_block, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val card = v.findViewById<CardView>(R.id.card)
        val dayOfWeek = v.findViewById<TextView>(R.id.dayOfWeek)
        //val weatherIcon = v.findViewById<ImageView>(R.id.weatherIcon)
        val temperature = v.findViewById<TextView>(R.id.temperature)
        val humidity = v.findViewById<TextView>(R.id.humidity)

        fun bind(item: WeatherResponse) {
            temperature.text = item.main.temp.toString()
            humidity.text = item.main.humidity.toString()
            dayOfWeek.text = item.timezone.toString()
            //Picasso.get().load(item.weather.).into(weatherIcon)

            card.setOnClickListener {
                Log.v("Pulso sobre", item.id.toString())
            }
        }


    }
}