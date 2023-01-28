package com.metehanbolat.core.data.di.datasource

import com.metehanbolat.core.data.source.datastore.TimeDataStoreDataSource
import com.metehanbolat.core.data.source.datastore.TimeDataStoreDataSourceImpl
import com.metehanbolat.core.data.source.local.LocalDataSource
import com.metehanbolat.core.data.source.local.LocalDataSourceImpl
import com.metehanbolat.core.data.source.remote.RemoteDataSource
import com.metehanbolat.core.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindDataStoreDataSource(timeDataStoreDataSourceImpl: TimeDataStoreDataSourceImpl): TimeDataStoreDataSource

}