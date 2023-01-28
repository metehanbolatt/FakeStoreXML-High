package com.metehanbolat.core.domain.usecase.database.addproducttodatabaseusecase

import com.metehanbolat.core.domain.model.ProductDbModel

interface AddProductToDatabaseUseCase {

    suspend operator fun invoke(product: ProductDbModel)
}