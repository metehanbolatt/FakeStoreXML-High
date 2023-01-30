package com.metehanbolat.core.data.api

import com.google.common.truth.Truth.assertThat
import com.metehanbolat.core.data.constant.SAMPLE_RESPONSE_FILE_NAME
import com.metehanbolat.core.data.constant.SAMPLE_RESPONSE_FILE_NAME_2
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FakeStoreApiTest {

    private lateinit var api: FakeStoreApi
    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.start()
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeStoreApi::class.java)
    }

    @Test
    fun `when I requested for get all product`() {
        runBlocking {
            enqueueResponse()
            val response = api.getAllProducts()
            val request = mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }
    }

    @Test
    fun `request control`() {
        runBlocking {
            enqueueResponse()
            api.getLimitedProducts("1")
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo("/products?limit=1")
        }
    }

    @Test
    fun `request control 2`() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME_2)
            api.getProductFromId("2")
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo("/products/2")
        }
    }

    @Test
    fun `item id control`() {
        runBlocking {
            enqueueResponse()
            val response = api.getLimitedProducts("4")
            val firstItem = response.first()
            assertThat(firstItem.id).isEqualTo(1)
        }
    }

    private fun enqueueResponse(fileName: String = SAMPLE_RESPONSE_FILE_NAME) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            mockWebServer.enqueue(mockResponse)
        }
    }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }

}