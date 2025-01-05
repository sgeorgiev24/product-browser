package com.sgeorgiev24.productbrowser.presentation.navigation.destination

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationAction
import com.sgeorgiev24.productbrowser.presentation.screen.details.DetailsScreen
import com.sgeorgiev24.productbrowser.presentation.screen.favorites.FavoritesScreen
import com.sgeorgiev24.productbrowser.presentation.screen.home.HomeScreen

sealed class MainDests : NavigationAction {
    data object Home : MainDests() {
        override val route: String
            get() = "home"
    }

    data object Details : MainDests() {
        const val PRODUCT_ID_ARG = "productId"

        override val route: String
            get() = "details"
        override val arguments: List<NamedNavArgument>
            get() = listOf(navArgument(PRODUCT_ID_ARG) { type = NavType.IntType })
    }

    data object Favorites : MainDests() {
        override val route: String
            get() = "favorites"
    }
}

fun NavGraphBuilder.mainDestsComposables() {
    composable(MainDests.Home.route) {
        HomeScreen()
    }

    composable(MainDests.Details.route) {
        DetailsScreen()
    }

    composable(MainDests.Favorites.route) {
        FavoritesScreen()
    }
}
