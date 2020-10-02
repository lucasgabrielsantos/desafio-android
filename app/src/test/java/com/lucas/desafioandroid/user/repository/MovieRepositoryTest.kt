package com.lucas.desafioandroid.user.repository

import com.lucas.desafioandroid.user.model.User
import com.lucas.desafioandroid.user.network.PicPayService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieRepositoryTest {

    private lateinit var repository: PicPayRepository

    @MockK
    lateinit var service: PicPayService

    @MockK
    lateinit var user: User

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        coEvery { service.getUsers() } returns listOf(user)
        every { user.name } returns "Eduardo Santos"

        repository = PicPayRepository()
    }

    @Test
    fun getListTest() {
        runBlocking {
            repository.getListPicPay()
        }
        Assert.assertEquals("Eduardo Santos", user.name)
    }

}