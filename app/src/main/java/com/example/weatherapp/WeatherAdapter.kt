package com.example.weatherapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.model.Main

class WeatherAdapter(itemlist: Main, context: Context) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    var itemlist: Main? = null
    var context: Context? = null

    init {
        this.itemlist = itemlist
        this.context = context
    }

    
    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvTemp: TextView? = itemView?.findViewById(R.id.tempTV)
        val tvTempMin: TextView? = itemView?.findViewById(R.id.tempMinTV)
        val tvTempMax: TextView? = itemView?.findViewById(R.id.tempMaxTV)
        val tvHumidity: TextView? = itemView?.findViewById(R.id.humidityTV)
        val tvFeelsLike: TextView? = itemView?.findViewById(R.id.feelslikeTV)
        val tvPressure: TextView? = itemView?.findViewById(R.id.pressureTV)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder, position: Int) {


        holder.tvTemp?.setText("Temperature: " + itemlist?.temp.toString() + "°C")
        holder.tvTempMin?.setText("Minimum Temperature: " + itemlist?.tempMin.toString() + "°C")
        holder.tvTempMax?.setText("Maximum Temperature: " + itemlist?.tempMax.toString() + "°C")
        holder.tvHumidity?.setText("Humidity: " + itemlist?.humidity.toString() + "%")
        holder.tvFeelsLike?.setText("Feels Like: " + itemlist?.feelsLike.toString() + "°C")
        holder.tvPressure?.setText("Pressure: " + itemlist?.pressure.toString() + "hPa")


    }

    override fun getItemCount(): Int {
        return itemlist!!.toString().length
    }
}



