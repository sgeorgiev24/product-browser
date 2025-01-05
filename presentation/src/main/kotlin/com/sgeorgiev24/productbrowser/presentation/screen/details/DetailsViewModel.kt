package com.sgeorgiev24.productbrowser.presentation.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.sgeorgiev.productbrowser.domain.interactor.favorite.ToggleFavoriteUseCase
import com.sgeorgiev.productbrowser.domain.interactor.product.GetProductByIdUseCase
import com.sgeorgiev24.productbrowser.presentation.BaseViewModel
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.presentation.navigation.destination.MainDests.Details.PRODUCT_ID_ARG
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val navigationDispatcher: NavigationDispatcher,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : BaseViewModel<DetailsState, Unit, Unit>(DetailsState()) {
    init {
        val productId = savedStateHandle.get<String>(PRODUCT_ID_ARG)?.toIntOrNull()

        productId?.let { id ->
            viewModelScope.launch {
                getProductByIdUseCase(id = id)
                    .onSuccess { product ->
                        println("debug1914 product: ${product.thumbnail}")
                        mState.update {
                            it.copy(product = product)
                        }
                    }
            }
        }
    }

    fun onBackClicked() {
        viewModelScope.launch {
            navigationDispatcher.navigateBack()
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            state.value.product?.let { product ->
                val result = toggleFavoriteUseCase(product)

                if (result.isSuccess) {
                    mState.update {
                        it.copy(product = product.copy(isInFavorites = !product.isInFavorites))
                    }
                } else {
                    // TODO: handle errors
                }
            }
        }
    }
}