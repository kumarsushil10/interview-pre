package com.swan.roomretrofitmvvmhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.swan.roomretrofitmvvmhilt.models.ProductsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {
    val productList: MutableLiveData<Response<List<ProductsItem>>> = MutableLiveData()

    fun getProduct() {
        viewModelScope.launch {
            productList.value = repository.getNetworkCall()
        }
    }

    val getAllData: LiveData<List<ProductsItem>> = repository.getAllData
        .flowOn(Dispatchers.Main).asLiveData(context = viewModelScope.coroutineContext)

    fun addAllData(productList: List<ProductsItem>) =
        viewModelScope.launch { repository.addAllData(productList) }

}