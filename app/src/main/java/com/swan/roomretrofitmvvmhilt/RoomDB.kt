package com.swan.roomretrofitmvvmhilt

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.swan.roomretrofitmvvmhilt.models.ProductsItem

@Database(entities = [ProductsItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RoomDB : RoomDatabase() {
    abstract fun productDao(): ProductDao
}