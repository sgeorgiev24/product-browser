package com.sgeorgiev24.productbrowser

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationArg
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationCommand
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.destination.MainDests
import com.sgeorgiev24.productbrowser.presentation.navigation.destination.mainDestsComposables
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppRouter(
    navigationDispatcher: NavigationDispatcher,
    navController: NavHostController
) {
    LaunchedEffect(key1 = Unit) {
        navigationDispatcher.navigationCommands.collectLatest { navigationCommand ->
            when (navigationCommand) {
                NavigationCommand.Back -> navController.popBackStack()
                is NavigationCommand.Navigate -> {
                    navController.navigate(
                        route = navigationCommand.navAction.route,
                        navOptions = navigationCommand.navAction.navOptions
                    )
                }

                is NavigationCommand.PopToDestination -> {
                    navController.popBackStack(navigationCommand.route, navigationCommand.inclusive)
                }

                is NavigationCommand.NavigateWithArguments -> {
                    var route = navigationCommand.navAction.route
                    for (arg in navigationCommand.args) {
                        val value = when (arg) {
                            is NavigationArg.IntArg -> arg.value.toString()
                            is NavigationArg.StringArg -> arg.value
                            is NavigationArg.BooleanArg -> arg.value.toString()
                            is NavigationArg.StringArrayArg -> {
                                arg.value.joinToString("&") { "${arg.key}=$it" }
                                    .removePrefix("${arg.key}=")
                            }
                        }
                        route = route.replace(
                            "{${arg.key}}",
                            value
                        )
                    }
                    navController.navigate(
                        route = route,
                        navOptions = navigationCommand.navAction.navOptions
                    )
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = MainDests.Home.route
    ) {
        mainDestsComposables()
    }
}
