package com.lucas.desafioandroid.usecase

import com.lucas.desafioandroid.model.User
import com.lucas.desafioandroid.repository.PicPayRepository

class PicPayUseCase (private var repository: PicPayRepository){

    suspend fun getListUsers(): List<User>{
        return repository.getListPicPay()
    }
}