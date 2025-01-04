package com.sgeorgiev24.productbrowser.presentation.screen.home

import androidx.lifecycle.viewModelScope
import com.sgeorgiev.productbrowser.domain.interactor.product.SearchProducts
import com.sgeorgiev24.productbrowser.presentation.BaseViewModel
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.destination.MainDests
import com.sgeorgiev24.productbrowser.presentation.util.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val navigationDispatcher: NavigationDispatcher,
    private val searchProducts: SearchProducts
) : BaseViewModel<HomeState, HomeAction, Unit>(HomeState()) {

    private val onProductSearch: (String) -> Unit = debounce(
        coroutineScope = viewModelScope
    ) { query ->
        viewModelScope.launch {
            searchProducts(query)
                .onSuccess { productSearch ->
                    mState.update {
                        it.copy(products = productSearch.products)
                    }
                }
                .onFailure {
                    // TODO: handle errors
                }
        }
    }

    override suspend fun handleActions(action: HomeAction) {
        when (action) {
            HomeAction.OnFavoritesClick ->
                navigationDispatcher.navigateTo(MainDests.Favorites)

            is HomeAction.OnSearchQueryChange ->
                onSearchQueryChange(action.query)
        }
    }

    private fun onSearchQueryChange(query: String) {
        mState.update {
            it.copy(searchQuery = query)
        }

        if (query.isNotEmpty()) {
            onProductSearch(query)
        } else {
            mState.update {
                it.copy(products = null)
            }
        }
    }
}