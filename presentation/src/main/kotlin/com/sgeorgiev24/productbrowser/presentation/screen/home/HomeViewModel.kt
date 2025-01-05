package com.sgeorgiev24.productbrowser.presentation.screen.home

import androidx.lifecycle.viewModelScope
import com.sgeorgiev.productbrowser.domain.interactor.favorite.ToggleFavoriteUseCase
import com.sgeorgiev.productbrowser.domain.interactor.product.SearchProductsUseCase
import com.sgeorgiev24.productbrowser.domain.model.product.Product
import com.sgeorgiev24.productbrowser.presentation.BaseViewModel
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.destination.MainDests
import com.sgeorgiev24.productbrowser.presentation.util.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val navigationDispatcher: NavigationDispatcher,
    private val searchProductsUseCase: SearchProductsUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : BaseViewModel<HomeState, HomeAction, Unit>(HomeState()) {

    private val onProductSearch: (String) -> Unit = debounce(
        coroutineScope = viewModelScope
    ) { query ->
        viewModelScope.launch {
            searchProductsUseCase(query)
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
                searchProducts(action.query)

            is HomeAction.ToggleFavorite ->
                toggleFavorite(action.product)
        }
    }

    private suspend fun toggleFavorite(product: Product) {
        val result = toggleFavoriteUseCase(product)

        if (result.isSuccess) {
            val newProducts = mState.value.products?.map { item ->
                if (item.id == product.id) {
                    item.copy(isInFavorites = !item.isInFavorites)
                } else {
                    item
                }
            }

            mState.update {
                it.copy(
                    products = newProducts
                )
            }
        } else {
            // TODO: handle errors
        }
    }

    private fun searchProducts(query: String) {
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