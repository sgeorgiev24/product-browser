package com.sgeorgiev24.productbrowser.presentation.screen.home

import com.sgeorgiev24.productbrowser.presentation.BaseViewModel
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.destination.MainDests
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val navigationDispatcher: NavigationDispatcher
) : BaseViewModel<HomeState, HomeAction, Unit>(HomeState()) {
    override suspend fun handleActions(action: HomeAction) {
        when (action) {
            HomeAction.OnFavoritesClick ->
                navigationDispatcher.navigateTo(MainDests.Favorites)

            is HomeAction.OnSearchQueryChange ->
                mState.update {
                    it.copy(searchQuery = action.query)
                }
        }
    }
}