package com.sgeorgiev24.productbrowser.provider.network.product

import com.sgeorgiev24.productbrowser.provider.network.product.model.ProductsSearchResponse

interface ProductApiDataSource {
    suspend fun searchProducts(query: String): ProductsSearchResponse
}