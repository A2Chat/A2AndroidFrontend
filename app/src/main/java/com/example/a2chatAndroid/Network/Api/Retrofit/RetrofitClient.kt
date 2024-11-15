package com.example.a2chatAndroid.Network.Api.Retrofit

import com.example.a2chatAndroid.Network.Api.okhttp.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//retrofit instance
object RetroFitClient {
    private const val BASE_URL = "https://a2chat.mooo.com"

    val okHttpClient = OkHttpClient.Builder()
        /*TODO add token middleware*/
        .addInterceptor(AuthInterceptor(""))
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())  //converts object into readable
        .build()

    val apiService = retrofit.create(BackEndApiService::class.java)
}

