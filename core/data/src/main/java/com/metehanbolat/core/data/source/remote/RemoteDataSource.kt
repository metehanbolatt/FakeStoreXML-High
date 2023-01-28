package com.metehanbolat.core.data.source.remote

import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem

interface RemoteDataSource {

    suspend fun getAllProducts(): NetworkResponse<List<ProductItem>>
    suspend fun getLimitedProducts(limit: String): NetworkResponse<List<ProductItem>>
    suspend fun getProductFromId(id: String): NetworkResponse<ProductItem>

}