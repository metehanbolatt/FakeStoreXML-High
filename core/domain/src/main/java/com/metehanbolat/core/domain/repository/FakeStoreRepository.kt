package com.metehanbolat.core.domain.repository

import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductDbModel
import com.metehanbolat.core.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

interface FakeStoreRepository {

    /** Api */
    suspend fun getAllProducts(): NetworkResponse<List<ProductItem>>
    suspend fun getLimitedProducts(limit: String): NetworkResponse<List<ProductItem>>
    suspend fun getProductFromId(id: String): NetworkResponse<ProductItem>

    /** Room Database */
    fun readAllData(): Flow<List<ProductDbModel>>
    suspend fun addProduct(product: ProductDbModel)

}