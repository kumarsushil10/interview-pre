package com.swan.roomretrofitmvvmhilt

import com.swan.roomretrofitmvvmhilt.models.ProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("/products")
    suspend fun getNetworkCall():Response<List<ProductsItem>>
}