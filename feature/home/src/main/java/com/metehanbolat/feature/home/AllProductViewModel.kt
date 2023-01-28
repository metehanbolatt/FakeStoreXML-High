package com.metehanbolat.feature.home

import androidx.lifecycle.*
import com.metehanbolat.core.common.MainUIState
import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.mapper.ProductListMapper
import com.metehanbolat.core.domain.model.ProductDbModel
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.domain.usecase.database.addproducttodatabaseusecase.AddProductToDatabaseUseCaseImpl
import com.metehanbolat.core.domain.usecase.database.readallproductfromdatabaseusecase.ReadAllProductFromDatabaseUseCaseImpl
import com.metehanbolat.core.domain.usecase.datastore.readfromdatastore.ReadServiceCallTimeFromDataStoreUseCaseImpl
import com.metehanbolat.core.domain.usecase.datastore.savetodatastoreusecase.SaveServiceCallTimeToDataStoreUseCaseImpl
import com.metehanbolat.core.domain.usecase.network.getallproductsusecase.GetAllProductsUseCaseImpl
import com.metehanbolat.core.domain.usecase.network.getlimitedproductsusecase.GetLimitedProductsUseCaseImpl
import com.metehanbolat.core.presentation.ProductUIData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllProductViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCaseImpl,
    private val getLimitedProductsUseCase: GetLimitedProductsUseCaseImpl,
    private val readAllProductFromDatabaseUseCase: ReadAllProductFromDatabaseUseCaseImpl,
    private val addProductToDatabaseUseCase: AddProductToDatabaseUseCaseImpl,
    private val productsMapper: ProductListMapper<ProductItem, ProductUIData>,
    private val saveServiceCallTimeToDataStoreUseCase: SaveServiceCallTimeToDataStoreUseCaseImpl,
    readServiceCallTimeToDataStoreUseCase: ReadServiceCallTimeFromDataStoreUseCaseImpl
) : ViewModel() {

    private val _productUIDataState = MutableLiveData<MainUIState<List<ProductUIData>>>()
    val productUIDataState: LiveData<MainUIState<List<ProductUIData>>> get() = _productUIDataState

    private val _productListFromDatabase = MutableLiveData<List<ProductDbModel>>()
    val productListFromDatabase: LiveData<List<ProductDbModel>> get() = _productListFromDatabase

    val readFromDataStore = readServiceCallTimeToDataStoreUseCase().asLiveData()

    fun saveToDataStore(serviceCallTime: String) {
        viewModelScope.launch {
            saveServiceCallTimeToDataStoreUseCase(serviceCallTime = serviceCallTime)
        }
    }

    fun getAllProducts() {
        viewModelScope.launch {
            getAllProductsUseCase()
                .onStart { println("getAllProducts: onStart") }
                .onCompletion { println("getAllProducts: onCompletion") }
                .collect { response ->
                    when (response) {
                        NetworkResponse.Loading -> _productUIDataState.postValue(
                            MainUIState.Loading
                        )
                        is NetworkResponse.Error -> _productUIDataState.postValue(
                            MainUIState.Error(com.airbnb.lottie.R.string.abc_action_bar_home_description)
                        )

                        is NetworkResponse.Success -> {
                            response.result.forEach {
                                addProductsToDatabase(
                                    ProductDbModel(
                                        id = 0,
                                        productName = it.title.toString(),
                                        productImageUrl = it.image.toString()
                                    )
                                )
                            }
                            _productUIDataState.postValue(
                                MainUIState.Success(
                                    productsMapper.map(response.result)
                                )
                            )
                        }
                    }
                }
        }
    }

    fun getLimitedProducts(limit: String) {
        viewModelScope.launch {
            getLimitedProductsUseCase(limit = limit)
                .onStart { println("getLimitedProducts: onStart") }
                .onCompletion { println("getLimitedProducts: onCompletion") }
                .collect { response ->
                    when (response) {
                        NetworkResponse.Loading -> _productUIDataState.postValue(
                            MainUIState.Loading
                        )
                        is NetworkResponse.Error -> _productUIDataState.postValue(
                            MainUIState.Error(
                                com.airbnb.lottie.R.string.abc_action_bar_home_description
                            )
                        )
                        is NetworkResponse.Success -> _productUIDataState.postValue(
                            MainUIState.Success(
                                productsMapper.map(response.result)
                            )
                        )
                    }
                }
        }
    }

    fun addProductsToDatabase(product: ProductDbModel) {
        viewModelScope.launch {
            addProductToDatabaseUseCase(product = product)
        }
    }

    fun readAllProductFromDatabase() {
        viewModelScope.launch {
            readAllProductFromDatabaseUseCase()
                .onStart { println("readAllProductFromDatabase: onStart") }
                .onCompletion { println("readAllProductFromDatabase: onCompletion") }
                .collect { response ->
                    println("response: $response")
                    _productListFromDatabase.postValue(response)
                }
        }
    }
}