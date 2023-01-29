package com.metehanbolat.feature.home

import com.metehanbolat.core.domain.mapper.ProductListMapper
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.presentation.ProductUIData
import com.metehanbolat.feature.home.mapper.ProductMainUIMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindProductMainUIMapper(
        productMainUIMapperImpl: ProductMainUIMapperImpl
    ): ProductListMapper<ProductItem, ProductUIData>
}