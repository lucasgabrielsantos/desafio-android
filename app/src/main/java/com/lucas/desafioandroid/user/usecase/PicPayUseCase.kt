package com.lucas.desafioandroid.user.usecase

import com.lucas.desafioandroid.user.model.User
import com.lucas.desafioandroid.user.repository.PicPayRepository

class PicPayUseCase (private var repository: PicPayRepository){

    suspend fun getListUsers(): List<User>{
        return repository.getListPicPay()
    }
}