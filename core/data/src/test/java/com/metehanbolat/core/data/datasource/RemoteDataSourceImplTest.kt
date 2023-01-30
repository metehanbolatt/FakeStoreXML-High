package com.metehanbolat.core.data.datasource

import com.google.common.truth.Truth.assertThat
import com.metehanbolat.core.data.api.FakeStoreApi
import com.metehanbolat.core.data.constant.cardList
import com.metehanbolat.core.data.source.remote.RemoteDataSourceImpl
import com.metehanbolat.core.domain.common.NetworkResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RemoteDataSourceImplTest {

    @Mock
    private lateinit var fakeStoreApi: FakeStoreApi

    private lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImpl = RemoteDataSourceImpl(fakeStoreApi)
    }

    @Test
    fun `when store item list returned is state success`() {
        runBlocking {
            Mockito.`when`(fakeStoreApi.getLimitedProducts("1"))
                .thenReturn(
                    cardList
                )
            val response = remoteDataSourceImpl.getLimitedProducts("1")
            assertThat(response).isInstanceOf(NetworkResponse.Success::class.java)
        }
    }

    @Test
    fun `when store item list returned is state error`() {
        runBlocking {
            Mockito.`when`(fakeStoreApi.getLimitedProducts("1"))
                .thenReturn(
                    null
                )
            val response = remoteDataSourceImpl.getLimitedProducts("1")
            assertThat(response).isInstanceOf(NetworkResponse.Error::class.java)
        }
    }
}