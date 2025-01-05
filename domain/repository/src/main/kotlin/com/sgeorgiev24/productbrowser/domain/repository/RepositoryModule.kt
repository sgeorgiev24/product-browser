package com.sgeorgiev24.productbrowser.domain.repository

import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepository
import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepositoryImpl
import com.sgeorgiev24.productbrowser.provider.database.databaseModule
import com.sgeorgiev24.productbrowser.provider.network.networkModule
import org.koin.dsl.module

val repositoryModule = networkModule + databaseModule + module {
    single<ProductRepository> { ProductRepositoryImpl(get(), get()) }
}