package com.sgeorgiev24.productbrowser.presentation.screen.favorites

import com.sgeorgiev24.productbrowser.domain.model.product.Product

data class FavoritesState(
    val products: List<Product> = emptyList()
)
