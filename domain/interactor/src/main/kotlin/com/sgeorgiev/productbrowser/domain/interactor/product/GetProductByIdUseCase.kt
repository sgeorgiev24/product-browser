package com.sgeorgiev.productbrowser.domain.interactor.product

import com.sgeorgiev24.productbrowser.domain.model.product.Product
import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepository

class GetProductByIdUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Result<Product> {
        val favoriteProduct = productRepository.getFavoriteProductById(id)

        return if (favoriteProduct.isSuccess) {
            favoriteProduct.map { it.copy(isInFavorites = true) }
        } else {
            productRepository.getProductById(id)
        }
    }
}