package com.metehanbolat.feature.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.core.common.MainUIState
import com.metehanbolat.core.domain.common.NetworkResponse
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.domain.usecase.network.getproductfromid.GetProductFromIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductFromIdUseCase: GetProductFromIdUseCase
) : ViewModel() {

    private val _productState = MutableLiveData<MainUIState<ProductItem>>()
    val productState: LiveData<MainUIState<ProductItem>> get() = _productState

    fun getProductFromId(id: String) {
        viewModelScope.launch {
            getProductFromIdUseCase(id = id)
                .onStart { println("getProductFromId: onStart") }
                .onCompletion { println("getProductFromId: onCompletion") }
                .collect { response ->
                    when (response) {
                        NetworkResponse.Loading -> _productState.postValue(
                            MainUIState.Loading
                        )
                        is NetworkResponse.Error -> _productState.postValue(
                            MainUIState.Error(R.string.error)
                        )
                        is NetworkResponse.Success -> _productState.postValue(
                            MainUIState.Success(response.result)
                        )
                    }
                }
        }
    }

}