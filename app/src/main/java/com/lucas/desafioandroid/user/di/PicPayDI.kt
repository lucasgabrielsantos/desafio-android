package com.lucas.desafioandroid.user.di

import com.lucas.desafioandroid.user.network.PicPayRetrofit
import com.lucas.desafioandroid.user.repository.PicPayRepository
import com.lucas.desafioandroid.user.usecase.PicPayUseCase
import com.lucas.desafioandroid.user.viewmodel.PicPayViewModel
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