package com.sgeorgiev.productbrowser.domain.interactor.favorite

import com.sgeorgiev24.productbrowser.domain.model.product.Product
import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepository

class ToggleFavoriteUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(product: Product) =
        if (product.isInFavorites)
            productRepository.removeFromFavorites(product.id)
        else
            productRepository.addToFavorites(product)
}