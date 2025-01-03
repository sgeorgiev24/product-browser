package com.sgeorgiev24.productbrowser.presentation

import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationManager
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationManagerImpl
import org.koin.dsl.module

val presentationModule =
    module {
        single<NavigationManager> {
            NavigationManagerImpl()
        }

        single { NavigationDispatcher(get()) }
    }
