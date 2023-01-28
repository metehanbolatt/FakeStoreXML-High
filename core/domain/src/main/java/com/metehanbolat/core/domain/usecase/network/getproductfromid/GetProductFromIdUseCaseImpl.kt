package com.metehanbolat.core.domain.usecase.network.getproductfromid

import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.domain.repository.FakeStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductFromIdUseCaseImpl @Inject constructor(
    private val fakeStoreRepository: FakeStoreRepository
) : GetProductFromIdUseCase {

    override fun invoke(id: String): Flow<NetworkResponse<ProductItem>> =
        flow {
            emit(NetworkResponse.Loading)
            emit(fakeStoreRepository.getProductFromId(id = id))
        }
}