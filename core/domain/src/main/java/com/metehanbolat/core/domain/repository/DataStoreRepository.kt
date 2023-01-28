package com.metehanbolat.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveToDataStore(serviceCallTime: String)
    val readFromDataStore: Flow<String>
}