package com.lucas.desafioandroid.user.ui.activity

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import com.lucas.desafioandroid.R
import com.lucas.desafioandroid.RecyclerViewMatchers
import com.lucas.desafioandroid.user.helper.Constants.BASE_URL
import com.lucas.desafioandroid.user.network.PicPayRetrofit
import io.mockk.every
import io.mockk.mockkObject
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private val server = MockWebServer()
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
        setupServerUrl()
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    private fun setupServerUrl() {
        //TODO corrigir chamada do retrofit
//        mockkObject(PicPayRetrofit)
//        every { PicPayRetrofit(BASE_URL) } returns PicPayRetrofit.(
//            server.url("/").toString()
//        )
    }


    @Test
    fun shouldDisplayTitle() {
        mockSuccess()
        launchActivity<MainActivity>().apply {
            val expectedTitle = context.getString(R.string.title)
            moveToState(Lifecycle.State.RESUMED)
            onView(withText(expectedTitle)).check(matches(isDisplayed()))
        }
        server.shutdown()
    }

    @Test
    fun shouldDisplayListItem() {
        mockSuccess()
        launchActivity<MainActivity>().apply {
            moveToState(Lifecycle.State.RESUMED)
            RecyclerViewMatchers.atPosition(
                0,
                withText("@eduardo.santos")
            )
        }
        server.shutdown()
    }

    @Test
    fun shouldDisplayError() {
        launchActivity<MainActivity>().apply {
            val expectedError = context.getString(R.string.errorMessage)
            onView(withText(expectedError))
        }
        server.shutdown()
    }

    private fun mockSuccess() {
        val responseCodeSuccess = 200
        val body =
            "[{\"id\":1001,\"name\":\"Eduardo Santos\",\"img\":\"https://randomuser.me/api/portraits/men/9.jpg\",\"username\":\"@eduardo.santos\"}]"
        addRequest(responseCodeSuccess, body)
    }

    private fun addRequest(statusCode: Int, body: String = "") {
        server.enqueue(
            MockResponse().apply {
                setResponseCode(statusCode)
                setBody(body)
            }
        )
    }
}