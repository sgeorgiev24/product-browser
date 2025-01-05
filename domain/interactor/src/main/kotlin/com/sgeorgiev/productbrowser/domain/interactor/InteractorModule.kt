package com.sgeorgiev.productbrowser.domain.interactor

import com.sgeorgiev.productbrowser.domain.interactor.favorite.ToggleFavoriteUseCase
import com.sgeorgiev.productbrowser.domain.interactor.product.SearchProductsUseCase
import org.koin.dsl.module

val interactorModule = module {
    single { SearchProductsUseCase(get()) }

    single { ToggleFavoriteUseCase(get()) }
}