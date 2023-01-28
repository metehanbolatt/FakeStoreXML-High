package com.metehanbolat.feature.home.mapper

import com.metehanbolat.core.domain.mapper.ProductListMapper
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.presentation.ProductUIData
import javax.inject.Inject

class ProductMainUIMapperImpl @Inject constructor() :
    ProductListMapper<ProductItem, ProductUIData> {
    override fun map(input: List<ProductItem>?): List<ProductUIData> {
        return input?.map {
            ProductUIData(
                id = it.id.toString(),
                name = it.title ?: "",
                imageUrl = it.image ?: ""
            )
        } ?: emptyList()
    }
}