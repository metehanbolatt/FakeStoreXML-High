package com.metehanbolat.core.common.di

import androidx.lifecycle.LiveData
import com.metehanbolat.core.common.NetworkConnectivityLD
import com.metehanbolat.core.common.Status
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.scopes.ServiceScoped

@Module
@InstallIn(ServiceComponent::class)
abstract class SystemServiceModule {

    @Binds
    @ServiceScoped
    abstract fun bindNetworkConnectivityManager(networkConnectivityLD: NetworkConnectivityLD): LiveData<Status>
}