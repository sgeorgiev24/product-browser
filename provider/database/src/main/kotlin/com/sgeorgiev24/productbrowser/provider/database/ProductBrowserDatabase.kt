package com.sgeorgiev24.productbrowser.provider.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sgeorgiev24.productbrowser.provider.database.product.ProductEntity
import com.sgeorgiev24.productbrowser.provider.database.product.ProductsDao

@Database(
    entities = [
        ProductEntity::class
    ],
    version = 1
)
abstract class ProductBrowserDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}