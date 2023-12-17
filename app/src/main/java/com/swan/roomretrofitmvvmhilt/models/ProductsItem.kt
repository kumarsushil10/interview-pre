package com.swan.roomretrofitmvvmhilt.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "product")
data class ProductsItem(
    val category: String,
    val description: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)