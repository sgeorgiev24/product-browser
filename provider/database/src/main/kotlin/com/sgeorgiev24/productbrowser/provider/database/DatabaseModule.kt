package com.sgeorgiev24.productbrowser.provider.database

import androidx.room.Room
import com.sgeorgiev24.productbrowser.provider.database.product.ProductsDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single<ProductBrowserDatabase> {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            ProductBrowserDatabase::class.java,
            "productbrowser-database"
        ).fallbackToDestructiveMigration().build()
    }

    single<ProductsDao> { get<ProductBrowserDatabase>().productsDao() }
}