package com.metehanbolat.core.data.source.datastore

import kotlinx.coroutines.flow.Flow

interface TimeDataStoreDataSource {

    suspend fun saveToDataStore(serviceCallTime: String)
    val readFromDataStore: Flow<String>
}