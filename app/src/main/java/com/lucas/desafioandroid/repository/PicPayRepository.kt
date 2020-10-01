package com.lucas.desafioandroid.repository

import com.lucas.desafioandroid.network.PicPayRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PicPayRepository {

    suspend fun getListPicPay() =
        withContext(Dispatchers.IO) {
            PicPayRetrofit.service.getUsers()
        }
}