package com.metehanbolat.core.domain.usecase.datastore.readfromdatastore

import com.metehanbolat.core.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadServiceCallTimeFromDataStoreUseCaseImpl @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ReadServiceCallTimeFromDataStoreUseCase {

    override fun invoke(): Flow<String> = dataStoreRepository.readFromDataStore

}