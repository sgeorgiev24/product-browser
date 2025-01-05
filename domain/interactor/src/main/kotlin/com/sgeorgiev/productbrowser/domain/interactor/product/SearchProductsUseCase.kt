package com.sgeorgiev.productbrowser.domain.interactor.product

import com.sgeorgiev24.productbrowser.domain.model.product.ProductsSearch
import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepository

class SearchProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(query: String): Result<ProductsSearch> {
        val favoritesIds = productRepository.getFavorites().getOrNull()?.map { it.id } ?: emptyList()

        return productRepository.searchProducts(query)
            .map { productsSearch ->
                productsSearch.copy(
                    products = productsSearch.products.map { product ->
                        product.copy(isInFavorites = favoritesIds.contains(product.id))
                    }
                )
            }
    }
}