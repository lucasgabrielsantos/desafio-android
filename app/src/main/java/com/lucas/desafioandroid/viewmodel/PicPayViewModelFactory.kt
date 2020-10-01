package com.lucas.desafioandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.desafioandroid.usecase.PicPayUseCase

class PicPayViewModelFactory(private val useCase: PicPayUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PicPayUseCase::class.java)
            .newInstance(useCase)
    }
}