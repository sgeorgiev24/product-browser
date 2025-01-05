package com.sgeorgiev24.productbrowser.domain.model.product

data class ProductsSearch(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)