package com.metehanbolat.core.data.di.usecase

import com.metehanbolat.core.domain.usecase.database.addproducttodatabaseusecase.AddProductToDatabaseUseCase
import com.metehanbolat.core.domain.usecase.database.addproducttodatabaseusecase.AddProductToDatabaseUseCaseImpl
import com.metehanbolat.core.domain.usecase.database.readallproductfromdatabaseusecase.ReadAllProductFromDatabaseUseCase
import com.metehanbolat.core.domain.usecase.database.readallproductfromdatabaseusecase.ReadAllProductFromDatabaseUseCaseImpl
import com.metehanbolat.core.domain.usecase.datastore.readfromdatastore.ReadServiceCallTimeFromDataStoreUseCase
import com.metehanbolat.core.domain.usecase.datastore.readfromdatastore.ReadServiceCallTimeFromDataStoreUseCaseImpl
import com.metehanbolat.core.domain.usecase.datastore.savetodatastoreusecase.SaveServiceCallTimeToDataStoreUseCase
import com.metehanbolat.core.domain.usecase.datastore.savetodatastoreusecase.SaveServiceCallTimeToDataStoreUseCaseImpl
import com.metehanbolat.core.domain.usecase.network.getallproductsusecase.GetAllProductsUseCase
import com.metehanbolat.core.domain.usecase.network.getallproductsusecase.GetAllProductsUseCaseImpl
import com.metehanbolat.core.domain.usecase.network.getlimitedproductsusecase.GetLimitedProductsUseCase
import com.metehanbolat.core.domain.usecase.network.getlimitedproductsusecase.GetLimitedProductsUseCaseImpl
import com.metehanbolat.core.domain.usecase.network.getproductfromid.GetProductFromIdUseCase
import com.metehanbolat.core.domain.usecase.network.getproductfromid.GetProductFromIdUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllProductsUseCase(
        getAllProductsUseCaseImpl: GetAllProductsUseCaseImpl
    ): GetAllProductsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetLimitedProductsUseCase(
        getLimitedProductsUseCaseImpl: GetLimitedProductsUseCaseImpl
    ): GetLimitedProductsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetProductFromIdUseCase(
        getProductFromIdUseCaseImpl: GetProductFromIdUseCaseImpl
    ): GetProductFromIdUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindReadAllProductFromDatabaseUseCase(
        readAllProductFromDatabaseUseCaseImpl: ReadAllProductFromDatabaseUseCaseImpl
    ): ReadAllProductFromDatabaseUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindAddProductToDatabaseUseCase(
        addProductToDatabaseUseCaseImpl: AddProductToDatabaseUseCaseImpl
    ): AddProductToDatabaseUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindReadServiceCallTimeFromDataStoreUseCase(
        readServiceCallTimeFromDataStoreUseCaseImpl: ReadServiceCallTimeFromDataStoreUseCaseImpl
    ): ReadServiceCallTimeFromDataStoreUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSaveServiceCallTimeToDataStoreUseCase(
        saveServiceCallTimeFromDataStoreUseCaseImpl: SaveServiceCallTimeToDataStoreUseCaseImpl
    ): SaveServiceCallTimeToDataStoreUseCase

}