package com.sgeorgiev24.productbrowser.presentation.screen.home

import com.sgeorgiev24.productbrowser.domain.model.product.Product

data class HomeState(
    val searchQuery: String = "",
    val products: List<Product>? = null
)
