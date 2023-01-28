package com.metehanbolat.core.domain.usecase.network.getlimitedproductsusecase

import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

interface GetLimitedProductsUseCase {

    operator fun invoke(limit: String): Flow<NetworkResponse<List<ProductItem>>>

}