package com.sgeorgiev24.productbrowser.domain.repository.product

import com.sgeorgiev24.productbrowser.domain.model.product.ProductsSearch

interface ProductRepository {
    suspend fun searchProducts(query: String): Result<ProductsSearch>
}