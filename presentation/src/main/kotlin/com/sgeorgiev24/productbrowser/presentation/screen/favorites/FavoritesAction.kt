package com.sgeorgiev24.productbrowser.presentation.screen.favorites

import com.sgeorgiev24.productbrowser.domain.model.product.Product

sealed class FavoritesAction {
    data class ToggleFavorite(val product: Product) : FavoritesAction()
    data class OpenProductDetails(val productId: Int) : FavoritesAction()
    data object Back : FavoritesAction()
}