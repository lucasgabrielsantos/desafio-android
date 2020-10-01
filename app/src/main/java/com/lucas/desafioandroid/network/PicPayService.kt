package com.lucas.desafioandroid.network

import com.lucas.desafioandroid.model.User
import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    suspend fun getUsers(): List<User>
}