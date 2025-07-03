package com.example.myweather.features

import com.example.myweather.models.Weather
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitAPI {

    @POST("weather")
    fun getWeather(
        @Query("lat") latitude: Double?,
        @Query("lon") longitude: Double?,
        @Query("appid") apiKey: String,
        @Query("units") units : String = "metric"
    ) : Call<Weather>
}