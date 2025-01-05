package com.sgeorgiev24.productbrowser.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel()
    val state: HomeState by viewModel.state.collectAsState()

    HomeContent(
        state = state,
        action = { viewModel.submitAction(it) }
    )
}
