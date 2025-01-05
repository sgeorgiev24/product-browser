package com.sgeorgiev24.productbrowser.presentation.screen.details

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.AndroidViewBinding
import coil3.load
import com.sgeorgiev.productbrowser.presentation.databinding.DetailsViewBinding
import org.koin.androidx.compose.koinViewModel

@SuppressLint("NewApi")
@Composable
fun DetailsScreen() {
    val viewModel: DetailsViewModel = koinViewModel()
    val state: DetailsState by viewModel.state.collectAsState()

    AndroidViewBinding(DetailsViewBinding::inflate) {
        this.thumbnail.load(state.product?.thumbnail)
        this.viewModel = viewModel
        this.isFavorite = state.product?.isInFavorites ?: false
    }
}