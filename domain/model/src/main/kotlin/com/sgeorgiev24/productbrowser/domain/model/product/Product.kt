package com.sgeorgiev24.productbrowser.domain.model.product

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
    val isInFavorites: Boolean = false
)