package com.metehanbolat.core.data.source.remote

import com.metehanbolat.core.data.extension.toProductItem
import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val fakeStoreApi: com.metehanbolat.core.data.api.FakeStoreApi
) : RemoteDataSource {

    override suspend fun getAllProducts(): NetworkResponse<List<ProductItem>> =
        try {
            val response = fakeStoreApi.getAllProducts().map { it.toProductItem() }
            NetworkResponse.Success(result = response)
        } catch (e: Exception) {
            NetworkResponse.Error(exception = e)
        }

    override suspend fun getLimitedProducts(limit: String): NetworkResponse<List<ProductItem>> =
        try {
            val response = fakeStoreApi.getLimitedProducts(limit = limit).map { it.toProductItem() }
            NetworkResponse.Success(result = response)
        } catch (e: Exception) {
            NetworkResponse.Error(exception = e)
        }

    override suspend fun getProductFromId(id: String): NetworkResponse<ProductItem> =
        try {
            val response = fakeStoreApi.getProductFromId(id = id).toProductItem()
            NetworkResponse.Success(result = response)
        } catch (e: Exception) {
            NetworkResponse.Error(exception = e)
        }

}