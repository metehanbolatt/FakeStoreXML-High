package com.metehanbolat.core.domain.usecase.network.getproductfromid

import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

interface GetProductFromIdUseCase {

    operator fun invoke(id: String): Flow<NetworkResponse<ProductItem>>
}