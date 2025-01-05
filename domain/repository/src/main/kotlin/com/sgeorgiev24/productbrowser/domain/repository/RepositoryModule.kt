package com.sgeorgiev24.productbrowser.domain.repository

import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepository
import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get(), get()) }
}