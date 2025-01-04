package com.sgeorgiev24.productbrowser.domain.repository.mapper

import com.sgeorgiev24.productbrowser.domain.model.product.Product
import com.sgeorgiev24.productbrowser.domain.model.product.ProductsSearch
import com.sgeorgiev24.productbrowser.provider.network.product.model.ProductResponse
import com.sgeorgiev24.productbrowser.provider.network.product.model.ProductsSearchResponse

fun ProductResponse.toDomain() =
    Product(
        id = id,
        title = title,
        description = description
    )

fun ProductsSearchResponse.toDomain() =
    ProductsSearch(
        products = products.map { it.toDomain() },
        total = total,
        skip = skip,
        limit = limit
    )