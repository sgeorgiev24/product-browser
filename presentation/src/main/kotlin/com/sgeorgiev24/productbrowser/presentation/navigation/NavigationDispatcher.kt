package com.sgeorgiev24.productbrowser.presentation.navigation

import kotlinx.coroutines.flow.Flow

class NavigationDispatcher(
    private val navigationManager: NavigationManager
) {
    val navigationCommands: Flow<NavigationCommand> = navigationManager.navActions

    suspend fun navigateTo(navAction: NavigationAction) {
        navigationManager.navigate(NavigationCommand.Navigate(navAction))
    }

    suspend fun navigateBack() {
        navigationManager.navigate(NavigationCommand.Back)
    }

    suspend fun popToDestination(
        navAction: NavigationAction,
        inclusive: Boolean
    ) {
        navigationManager.navigate(NavigationCommand.PopToDestination(navAction.route, inclusive))
    }
}
