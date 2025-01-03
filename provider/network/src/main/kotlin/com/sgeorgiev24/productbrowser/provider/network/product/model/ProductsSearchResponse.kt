package com.sgeorgiev24.productbrowser.provider.network.product.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductsSearchResponse(
    val products: List<ProductResponse>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
