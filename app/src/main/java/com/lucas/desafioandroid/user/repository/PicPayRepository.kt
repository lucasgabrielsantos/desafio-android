package com.lucas.desafioandroid.user.repository

import com.lucas.desafioandroid.user.network.PicPayRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PicPayRepository {

    suspend fun getListPicPay() =
        withContext(Dispatchers.IO) {
            PicPayRetrofit.service.getUsers()
        }
}