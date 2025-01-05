package com.sgeorgiev24.productbrowser.presentation.screen.home

import com.sgeorgiev24.productbrowser.domain.model.product.Product

sealed class HomeAction {
    data object OnFavoritesClick : HomeAction()
    data class OnSearchQueryChange(val query: String) : HomeAction()
    data class ToggleFavorite(val product: Product) : HomeAction()
    data class OpenProductDetails(val productId: Int) : HomeAction()
}