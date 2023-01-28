package com.metehanbolat.core.domain.usecase.network.getallproductsusecase

import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

interface GetAllProductsUseCase {

    operator fun invoke(): Flow<NetworkResponse<List<ProductItem>>>

}