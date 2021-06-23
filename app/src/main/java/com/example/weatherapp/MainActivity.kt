package com.example.weatherapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.Main
import com.example.weatherapp.model.WeatherResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    val BASE_URL = "http://api.openweathermap.org/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mRecyclerView: RecyclerView? = null
        val mRecyclerView2: RecyclerView? = null


        var client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)

        var rf = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
        var rf2 = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()

        var API = rf.create(MyApiCall::class.java)
        var call = API.getMovieData()

        var API2 = rf2.create(MyApiCall::class.java)
        var call2 = API2.getMovieData()

        call?.enqueue(object : Callback<WeatherResponse?> {
            override fun onResponse(
                call: Call<WeatherResponse?>,
                response: Response<WeatherResponse?>
            ) {
                var weatherList = response
                var adapterWeather: WeatherAdapter = WeatherAdapter(weatherList.body()?.main!!, applicationContext)


                Log.d("OnResponse", weatherList.code().toString() +" "+weatherList.message())
                Log.d("OnRespone", adapterWeather?.itemlist?.temp.toString())

                binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                binding.recyclerView.adapter = adapterWeather
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<WeatherResponse?>, t: Throwable) {
                Log.d("OnResponse", t.toString())
            }


        })

//        //Sky
//        call2?.enqueue(object : Callback<WeatherResponse?> {
//            override fun onResponse(
//                call2: Call<WeatherResponse?>,
//                response2: Response<WeatherResponse?>
//            ) {
//                var movieList2 = response2
//                var adapterImage: ImageAdapter =
//                    ImageAdapter(movieList2.body()?.weather!!, applicationContext)
//
//                Log.d("OnResponse", movieList2.code().toString() +" "+movieList2.message())
//                binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
//                binding.recyclerView.adapter = adapterImage
//                binding.recyclerView.adapter?.notifyDataSetChanged()
//            }
//
//            override fun onFailure(call2: Call<WeatherResponse?>, t: Throwable) {
//                Log.d("OnResponse", t.toString())
//            }
//
//
//        })

    }
}