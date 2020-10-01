package com.lucas.desafioandroid.usecase

import com.lucas.desafioandroid.model.User
import com.lucas.desafioandroid.repository.PicPayRepository
import com.lucas.desafioandroid.usecase.PicPayUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieUseCaseTest {

    @MockK
    lateinit var repository: PicPayRepository

    @MockK
    lateinit var useCase: PicPayUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        val user = getUser()
        coEvery { repository.getListPicPay() } returns (listOf(user))
        useCase = PicPayUseCase(repository)
    }

    @Test
    fun getListTest() {
        val result = runBlocking {
            useCase.getListUsers()
        }
        Assert.assertEquals("Eduardo Santos", result[0].name)
    }

    private fun getUser() = User(
        1, "test","Eduardo Santos","@eduardo.santos"
    )
}