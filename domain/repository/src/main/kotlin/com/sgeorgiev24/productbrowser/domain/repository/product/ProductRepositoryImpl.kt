package com.sgeorgiev24.productbrowser.domain.repository.product

import com.sgeorgiev24.productbrowser.domain.model.product.Product
import com.sgeorgiev24.productbrowser.domain.repository.mapper.toDomain
import com.sgeorgiev24.productbrowser.domain.repository.mapper.toEntity
import com.sgeorgiev24.productbrowser.provider.database.ProductBrowserDatabase
import com.sgeorgiev24.productbrowser.provider.database.util.safeDatabaseCall
import com.sgeorgiev24.productbrowser.provider.network.product.ProductApiDataSource
import com.sgeorgiev24.productbrowser.provider.network.util.safeApiCall

class ProductRepositoryImpl(
    private val productApiDataSource: ProductApiDataSource,
    private val database: ProductBrowserDatabase
) : ProductRepository {
    override suspend fun searchProducts(query: String) =
        safeApiCall {
            productApiDataSource.searchProducts(query)
        }.map { it.toDomain() }

    override suspend fun getFavorites() =
        safeDatabaseCall {
            database.productsDao().getFavoriteProducts().map { it.toDomain() }
        }

    override suspend fun addToFavorites(product: Product) =
        safeDatabaseCall {
            database.productsDao().insert(product.toEntity())
        }

    override suspend fun removeFromFavorites(id: Int) =
        safeDatabaseCall {
            database.productsDao().deleteById(id)
        }

    override suspend fun getFavoriteProductById(id: Int) =
        safeDatabaseCall {
            database.productsDao().getFavoriteProductById(id).toDomain()
        }
}