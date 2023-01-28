package com.metehanbolat.core.domain.usecase.datastore.savetodatastoreusecase

interface SaveServiceCallTimeToDataStoreUseCase {

    suspend operator fun invoke(serviceCallTime: String)
}