package com.sgeorgiev24.productbrowser.presentation.screen.home

sealed class HomeAction {
    data object OnFavoritesClick : HomeAction()
    data class OnSearchQueryChange(val query: String) : HomeAction()
}