package com.sgeorgiev24.productbrowser.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavOptions

interface NavigationAction {
    val route: String
    val navOptions: NavOptions
        get() = NavOptions.Builder().build()
    val arguments: List<NamedNavArgument>
        get() = emptyList()
}
