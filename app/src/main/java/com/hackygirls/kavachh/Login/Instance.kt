package com.hackygirls.kavachh.Login

import com.hackygirls.kavachh.transactions.TrnsacApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Instance {
    private var  base_url = "https://kavach-amex.herokuapp.com/KavachAuth/"


    private val client = OkHttpClient.Builder().build()
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }
}