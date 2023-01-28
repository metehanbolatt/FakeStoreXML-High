package com.metehanbolat.core.domain.usecase.datastore.savetodatastoreusecase

import com.metehanbolat.core.domain.repository.DataStoreRepository
import javax.inject.Inject

class SaveServiceCallTimeToDataStoreUseCaseImpl @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : SaveServiceCallTimeToDataStoreUseCase {

    override suspend fun invoke(serviceCallTime: String) =
        dataStoreRepository.saveToDataStore(serviceCallTime = serviceCallTime)
}