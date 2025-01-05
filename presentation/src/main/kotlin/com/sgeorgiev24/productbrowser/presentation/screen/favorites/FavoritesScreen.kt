package com.sgeorgiev24.productbrowser.presentation.screen.favorites

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.sgeorgiev24.productbrowser.presentation.util.ObserverLifecycleEvents
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    val viewModel: FavoritesViewModel = koinViewModel()
    val state: FavoritesState by viewModel.state.collectAsState()

    ObserverLifecycleEvents(
        onResume = {
            viewModel.loadFavorites()
        }
    )

    FavoritesContent(
        state = state,
        action = { viewModel.submitAction(it) }
    )
}