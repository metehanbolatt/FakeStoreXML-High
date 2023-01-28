package com.metehanbolat.core.domain.usecase.network.getallproductsusecase

import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.domain.repository.FakeStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val fakeStoreRepository: FakeStoreRepository
) : GetAllProductsUseCase {

    override fun invoke(): Flow<NetworkResponse<List<ProductItem>>> =
        flow {
            emit(NetworkResponse.Loading)
            emit(fakeStoreRepository.getAllProducts())
        }

}