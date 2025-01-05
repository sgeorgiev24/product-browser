package com.sgeorgiev24.productbrowser.presentation.navigation

sealed class NavigationCommand {
    data class Navigate(val navAction: NavigationAction) : NavigationCommand()

    data class PopToDestination(
        val route: String,
        val inclusive: Boolean
    ) : NavigationCommand()

    data class NavigateWithArguments(
        val navAction: NavigationAction,
        val args: List<NavigationArg>
    ) : NavigationCommand()

    object Back : NavigationCommand()
}
