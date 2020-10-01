package com.lucas.desafioandroid.usecase

import com.lucas.desafioandroid.model.Users
import com.lucas.desafioandroid.repository.PicPayRepository

class PicPayUseCase (private var repository: PicPayRepository){

    suspend fun getListUsers(): List<Users>{
        return repository.getListPicPay()
    }
}