package com.metehanbolat.core.domain.usecase.database.readallproductfromdatabaseusecase

import com.metehanbolat.core.domain.model.ProductDbModel
import com.metehanbolat.core.domain.repository.FakeStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAllProductFromDatabaseUseCaseImpl @Inject constructor(
    private val fakeStoreRepository: FakeStoreRepository
) : ReadAllProductFromDatabaseUseCase {

    override fun invoke(): Flow<List<ProductDbModel>> = fakeStoreRepository.readAllData()
}