package com.example.weatherapp

import com.example.weatherapp.model.Main
import com.example.weatherapp.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET

interface MyApiCall {

    @GET("data/2.5/weather?q=Dhaka&units=metric&appid=7b03e9666c06a093f0e1b9bb6aa14a25")
    fun getMovieData(): Call<WeatherResponse?>?

}