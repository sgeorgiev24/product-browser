package com.sgeorgiev.productbrowser.domain.interactor.product

import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepository

class SearchProducts(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(query: String) =
        productRepository.searchProducts(query)
}