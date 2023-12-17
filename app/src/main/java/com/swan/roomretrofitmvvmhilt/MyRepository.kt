package com.swan.roomretrofitmvvmhilt

import com.swan.roomretrofitmvvmhilt.models.ProductsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val myApi: MyApi,
    private val productDao: ProductDao
) {

    suspend fun getNetworkCall(): Response<List<ProductsItem>> {
        return myApi.getNetworkCall()
    }

    suspend fun addAllData(productList: List<ProductsItem>) = withContext(Dispatchers.IO) {
        productDao.addAllData(productList)
    }

    val getAllData: Flow<List<ProductsItem>> = productDao.getAllProduct()

}