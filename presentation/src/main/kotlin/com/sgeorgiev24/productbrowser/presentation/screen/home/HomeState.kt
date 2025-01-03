package com.sgeorgiev24.productbrowser.presentation.screen.home

data class HomeState(
    val searchQuery: String = "",
    val products: List<String>? = null
)
