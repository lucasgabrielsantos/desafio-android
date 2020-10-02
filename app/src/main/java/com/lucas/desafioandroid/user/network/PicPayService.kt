package com.lucas.desafioandroid.user.network

import com.lucas.desafioandroid.user.model.User
import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    suspend fun getUsers(): List<User>
}