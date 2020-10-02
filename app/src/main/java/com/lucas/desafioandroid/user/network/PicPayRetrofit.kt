package com.lucas.desafioandroid.user.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lucas.desafioandroid.user.helper.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object PicPayRetrofit {
    private val gson: Gson by lazy { GsonBuilder().create() }
    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }
    val service: PicPayService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttp)
            .build()

        service = retrofit.create(PicPayService::class.java)
    }
}