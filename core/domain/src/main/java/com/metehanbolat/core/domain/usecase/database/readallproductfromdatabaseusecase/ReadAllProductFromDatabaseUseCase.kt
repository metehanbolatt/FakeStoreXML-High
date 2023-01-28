package com.metehanbolat.core.domain.usecase.database.readallproductfromdatabaseusecase

import com.metehanbolat.core.domain.model.ProductDbModel
import kotlinx.coroutines.flow.Flow

interface ReadAllProductFromDatabaseUseCase {

    operator fun invoke(): Flow<List<ProductDbModel>>

}