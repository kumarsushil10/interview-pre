package com.swan.roomretrofitmvvmhilt

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.swan.roomretrofitmvvmhilt.models.ProductsItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert
    suspend fun addAllData(productList: List<ProductsItem>)

    @Query("Select * from product order by id asc")
    fun getAllProduct(): Flow<List<ProductsItem>>
}