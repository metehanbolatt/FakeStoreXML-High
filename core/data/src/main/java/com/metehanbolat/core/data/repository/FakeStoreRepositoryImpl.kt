package com.metehanbolat.core.data.repository

import com.metehanbolat.core.data.di.coroutine.IoDispatcher
import com.metehanbolat.core.data.source.local.LocalDataSource
import com.metehanbolat.core.data.source.remote.RemoteDataSource
import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductDbModel
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.domain.repository.FakeStoreRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FakeStoreRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FakeStoreRepository {

    override suspend fun getAllProducts(): NetworkResponse<List<ProductItem>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getAllProducts()
            } catch (e: Exception) {
                NetworkResponse.Error(exception = e)
            }
        }

    override suspend fun getLimitedProducts(limit: String): NetworkResponse<List<ProductItem>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getLimitedProducts(limit = limit)
            } catch (e: Exception) {
                NetworkResponse.Error(exception = e)
            }
        }

    override suspend fun getProductFromId(id: String): NetworkResponse<ProductItem> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getProductFromId(id = id)
            } catch (e: Exception) {
                NetworkResponse.Error(exception = e)
            }
        }

    override fun readAllData(): Flow<List<ProductDbModel>> = localDataSource.readAllData()

    override suspend fun addProduct(product: ProductDbModel) =
        withContext(ioDispatcher) {
            try {
                localDataSource.addProduct(product = product)
            } catch (e: Exception) {
                println("FakeStoreRepositoryImpl addProduct Function Exception: ${e.localizedMessage}")
            }
        }
}