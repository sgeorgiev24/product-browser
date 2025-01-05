package com.sgeorgiev24.productbrowser.presentation.screen.favorites

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    val viewModel: FavoritesViewModel = koinViewModel()
    val state: FavoritesState by viewModel.state.collectAsState()

    FavoritesContent(
        state = state,
        action = { viewModel.submitAction(it) }
    )
}