package com.sgeorgiev24.productbrowser.presentation.screen.favorites

import androidx.lifecycle.viewModelScope
import com.sgeorgiev.productbrowser.domain.interactor.favorite.GetAllFavoritesUseCase
import com.sgeorgiev.productbrowser.domain.interactor.favorite.ToggleFavoriteUseCase
import com.sgeorgiev24.productbrowser.domain.model.product.Product
import com.sgeorgiev24.productbrowser.presentation.BaseViewModel
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.destination.MainDests
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val navigationDispatcher: NavigationDispatcher,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : BaseViewModel<FavoritesState, FavoritesAction, Unit>(FavoritesState()) {

    init {
        viewModelScope.launch {
            loadFavorites()
        }
    }

    override suspend fun handleActions(action: FavoritesAction) {
        when (action) {
            is FavoritesAction.ToggleFavorite ->
                toggleFavorite(action.product)

            FavoritesAction.Back ->
                navigationDispatcher.navigateBack()

            is FavoritesAction.OpenProductDetails ->
                navigationDispatcher.navigateTo(MainDests.Details)
        }
    }

    private suspend fun toggleFavorite(product: Product) {
        val result = toggleFavoriteUseCase(product)

        if (result.isSuccess) {
            val newProducts = mState.value.products.map { item ->
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

    private suspend fun loadFavorites() {
        val favorites = getAllFavoritesUseCase().getOrNull() ?: emptyList()
        mState.update {
            it.copy(products = favorites)
        }
    }
}