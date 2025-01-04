package com.sgeorgiev24.productbrowser.presentation

import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationManager
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationManagerImpl
import com.sgeorgiev24.productbrowser.presentation.screen.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule =
    module {
        single<NavigationManager> {
            NavigationManagerImpl()
        }

        single { NavigationDispatcher(get()) }

        viewModel { HomeViewModel(get(), get()) }
    }
