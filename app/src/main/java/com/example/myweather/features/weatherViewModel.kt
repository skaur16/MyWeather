package com.example.myweather.features

import android.content.Context
import android.location.Geocoder
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myweather.models.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale

class weatherViewModel : ViewModel() {

    var locationText = mutableStateOf("")

    var weatherInfo = mutableStateOf<Weather?>(null)

    var cardVisible = mutableStateOf(false)

    var isLoading = mutableStateOf(false)


    fun getWeather(context : Context) {

        //we received the coordinates from the location
        var cord = getCord(locationText.value, context)
        var latitude = cord[0]
        var longitude = cord[1]

        Log.e("LATITUDE", latitude.toString())
        Log.e("LONGITUDE", longitude.toString())

        if (latitude == null || longitude == null) {
            Toast.makeText(context, "Location not found", Toast.LENGTH_SHORT).show()
            return
        }

        //we get the weather from the coordinates

        var url = "https://api.openweathermap.org/data/2.5/"
        var apiKey = "71ebe1edc43ac3cb66d6770af5af857f"
        //create retrofit object
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //call create method with the retrofit object
         val retrofitApi = retrofit.create(RetrofitAPI::class.java)

        //build an interface
        //call API from interface API
        val call = retrofitApi.getWeather(latitude, longitude, apiKey)

        //execute the call with enqueue method

        call.enqueue(object : Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                Log.e("RESPONSE", response.body().toString())
                weatherInfo.value = response.body()
                Log.e("WeatherInfo", weatherInfo.value.toString())
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.e("Try Again", t.message.toString())
            }

        })

    }

    private fun getCord(locationText: String, context: Context): List<Double?> {

        return try{

            var geocoder = Geocoder(context , Locale.getDefault())
            var address = geocoder.getFromLocationName(locationText,1)
            Log.e("ADDRESS", address.toString())
            var lat = address?.get(0)?.latitude
            var long = address?.get(0)?.longitude
            return listOf(lat, long)
        } catch(e : Exception){
            e.printStackTrace()
            listOf(null, null)
        }
    }



}