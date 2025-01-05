package com.sgeorgiev.productbrowser.domain.interactor.favorite

import com.sgeorgiev24.productbrowser.domain.repository.product.ProductRepository

class GetAllFavoritesUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke() =
        productRepository.getFavorites().map {
            it.map { product -> product.copy(isInFavorites = true) }
        }
}