package com.sgeorgiev24.productbrowser.provider.network.product

import com.sgeorgiev24.productbrowser.provider.network.product.model.ProductResponse
import com.sgeorgiev24.productbrowser.provider.network.product.model.ProductsSearchResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path

class ProductApiDataSourceImpl(
    private val client: HttpClient
) : ProductApiDataSource {
    override suspend fun searchProducts(query: String): ProductsSearchResponse {
        return client.get {
            url {
                path("products", "search")
                parameter("q", query)
            }
        }.body()
    }

    override suspend fun getProductById(id: Int): ProductResponse {
        return client.get {
            url {
                path("products", id.toString())
            }
        }.body()
    }
}