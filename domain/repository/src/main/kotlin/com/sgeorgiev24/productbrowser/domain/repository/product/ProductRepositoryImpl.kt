package com.sgeorgiev24.productbrowser.domain.repository.product

import com.sgeorgiev24.productbrowser.domain.repository.mapper.toDomain
import com.sgeorgiev24.productbrowser.provider.network.product.ProductApiDataSource
import com.sgeorgiev24.productbrowser.provider.network.util.safeApiCall

class ProductRepositoryImpl(
    private val productApiDataSource: ProductApiDataSource
) : ProductRepository {
    override suspend fun searchProducts(query: String) =
        safeApiCall {
            productApiDataSource.searchProducts(query)
        }.map { it.toDomain() }
}