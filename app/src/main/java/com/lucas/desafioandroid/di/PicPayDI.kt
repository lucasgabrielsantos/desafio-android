package com.lucas.desafioandroid.di

import com.lucas.desafioandroid.network.PicPayRetrofit
import com.lucas.desafioandroid.repository.PicPayRepository
import com.lucas.desafioandroid.usecase.PicPayUseCase
import com.lucas.desafioandroid.viewmodel.PicPayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object PicPayDI {
    private val viewModelModule = module {
        viewModel { PicPayViewModel(useCase = get()) }

        factory { PicPayUseCase(repository = get()) }
        factory { PicPayRepository() }
        single { PicPayRetrofit }
    }

    fun init() = loadKoinModules(viewModelModule)

}