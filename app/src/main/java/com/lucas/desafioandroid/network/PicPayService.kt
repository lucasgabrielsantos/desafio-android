package com.lucas.desafioandroid.network

import com.lucas.desafioandroid.model.Users
import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    suspend fun getUsers(): List<Users>
}