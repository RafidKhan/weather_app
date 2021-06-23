package com.example.weatherapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.model.WeatherItem


class ImageAdapter(imageList: List<WeatherItem?>, context: Context) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    var imageLists: List<WeatherItem?>? = null
    var context: Context? = null

    init {
        this.imageLists = imageList
        this.context = context
    }


    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvSkyCondition: TextView? = itemView?.findViewById(R.id.skyConditionTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvSkyCondition?.setText(imageLists?.get(position)?.description)

    }

    override fun getItemCount(): Int {
        return imageLists!!.size
    }


}



