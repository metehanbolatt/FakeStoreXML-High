package com.metehanbolat.core.domain.usecase.network.getlimitedproductsusecase

import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.domain.repository.FakeStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLimitedProductsUseCaseImpl @Inject constructor(
    private val fakeStoreRepository: FakeStoreRepository
) : GetLimitedProductsUseCase {

    override fun invoke(limit: String): Flow<NetworkResponse<List<ProductItem>>> =
        flow {
            emit(NetworkResponse.Loading)
            emit(fakeStoreRepository.getLimitedProducts(limit = limit))
        }
}