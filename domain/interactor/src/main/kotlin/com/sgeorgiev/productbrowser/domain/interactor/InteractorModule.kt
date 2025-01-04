package com.sgeorgiev.productbrowser.domain.interactor

import com.sgeorgiev.productbrowser.domain.interactor.product.SearchProducts
import org.koin.dsl.module

val interactorModule = module {
    single { SearchProducts(get()) }
}