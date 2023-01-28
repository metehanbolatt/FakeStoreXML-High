package com.metehanbolat.core.domain.usecase.database.addproducttodatabaseusecase

import com.metehanbolat.core.domain.model.ProductDbModel
import com.metehanbolat.core.domain.repository.FakeStoreRepository
import javax.inject.Inject

class AddProductToDatabaseUseCaseImpl @Inject constructor(
    private val fakeStoreRepository: FakeStoreRepository
) : AddProductToDatabaseUseCase {

    override suspend fun invoke(product: ProductDbModel) =
        fakeStoreRepository.addProduct(product = product)
}