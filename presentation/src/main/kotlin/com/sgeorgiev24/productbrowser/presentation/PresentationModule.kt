package com.sgeorgiev24.productbrowser.presentation

import com.sgeorgiev.productbrowser.domain.interactor.interactorModule
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationManager
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationManagerImpl
import com.sgeorgiev24.productbrowser.presentation.screen.details.DetailsViewModel
import com.sgeorgiev24.productbrowser.presentation.screen.favorites.FavoritesViewModel
import com.sgeorgiev24.productbrowser.presentation.screen.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = interactorModule +
    module {
        single<NavigationManager> {
            NavigationManagerImpl()
        }

        single { NavigationDispatcher(get()) }

        viewModel { HomeViewModel(get(), get(), get()) }

        viewModel { FavoritesViewModel(get(), get(), get()) }

        viewModel { DetailsViewModel(get(), get(), get(), get()) }
    }
