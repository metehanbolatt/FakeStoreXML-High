package com.metehanbolat.core.data.source.local

import com.metehanbolat.core.data.database.dao.ProductDao
import com.metehanbolat.core.domain.model.ProductDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: ProductDao
) : LocalDataSource {

    override fun readAllData(): Flow<List<ProductDbModel>> = dao.readAllData()

    override suspend fun addProduct(product: ProductDbModel) {
        dao.addProduct(product)
    }
}