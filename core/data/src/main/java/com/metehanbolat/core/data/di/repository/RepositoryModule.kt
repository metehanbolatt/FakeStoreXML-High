package com.metehanbolat.core.data.di.repository

import com.metehanbolat.core.data.repository.DataStoreRepositoryImpl
import com.metehanbolat.core.data.repository.FakeStoreRepositoryImpl
import com.metehanbolat.core.domain.repository.DataStoreRepository
import com.metehanbolat.core.domain.repository.FakeStoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindFakeStoreRepository(fakeStoreRepositoryImpl: FakeStoreRepositoryImpl): FakeStoreRepository

    @Binds
    @ViewModelScoped
    abstract fun bindTimeDataStoreRepository(dataStoreRepositoryImpl: DataStoreRepositoryImpl): DataStoreRepository
}