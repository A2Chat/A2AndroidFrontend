package com.example.a2chatAndroid.Network.RetrofitApi

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun fetchTestData() {
    val apiService = RetroFitClient.retrofit.create(BackEndApiService::class.java)
    apiService.test().enqueue(object : Callback<String> {  // Replace YourDataClass with the actual data class
        override fun onResponse(call: Call<String>, response: Response<String>) {
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null) {
                    Log.d("Retrofit", "Response: $data")
                    // Handle the response data
                } else {
                    Log.w("Retrofit", "Response body is null")
                }
            } else {
                Log.w("Retrofit", "Response not successful: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<String>, t: Throwable) {
            Log.w("Retrofit", "Request failed", t)
        }
    })
}
