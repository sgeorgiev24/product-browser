package com.sgeorgiev24.productbrowser.domain.repository.product

import com.sgeorgiev24.productbrowser.domain.model.product.Product
import com.sgeorgiev24.productbrowser.domain.model.product.ProductsSearch

interface ProductRepository {
    suspend fun searchProducts(query: String): Result<ProductsSearch>

    suspend fun getProductById(id: Int): Result<Product>

    suspend fun getFavorites(): Result<List<Product>>

    suspend fun addToFavorites(product: Product): Result<Unit>

    suspend fun removeFromFavorites(id: Int): Result<Unit>

    suspend fun getFavoriteProductById(id: Int): Result<Product>
}