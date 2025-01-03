package com.sgeorgiev24.productbrowser.presentation.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationAction
import com.sgeorgiev24.productbrowser.presentation.screen.details.DetailsScreen
import com.sgeorgiev24.productbrowser.presentation.screen.home.HomeScreen

sealed class MainDests : NavigationAction {
    data object Home : MainDests() {
        override val route: String
            get() = "home"
    }

    data object Details : MainDests() {
        override val route: String
            get() = "details"
    }
}

fun NavGraphBuilder.mainDestsComposables() {
    composable(MainDests.Home.route) {
        HomeScreen()
    }

    composable(MainDests.Details.route) {
        DetailsScreen()
    }
}
