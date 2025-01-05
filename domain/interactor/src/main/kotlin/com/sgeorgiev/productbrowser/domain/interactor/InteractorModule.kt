package com.sgeorgiev.productbrowser.domain.interactor

import com.sgeorgiev.productbrowser.domain.interactor.favorite.GetAllFavoritesUseCase
import com.sgeorgiev.productbrowser.domain.interactor.favorite.ToggleFavoriteUseCase
import com.sgeorgiev.productbrowser.domain.interactor.product.GetProductByIdUseCase
import com.sgeorgiev.productbrowser.domain.interactor.product.SearchProductsUseCase
import com.sgeorgiev24.productbrowser.domain.repository.repositoryModule
import org.koin.dsl.module

val interactorModule = repositoryModule + module {
    single { SearchProductsUseCase(get()) }

    single { ToggleFavoriteUseCase(get()) }

    single { GetAllFavoritesUseCase(get()) }

    single { GetProductByIdUseCase(get()) }
}