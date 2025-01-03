package com.sgeorgiev24.productbrowser.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sgeorgiev.productbrowser.presentation.R
import com.sgeorgiev24.productbrowser.presentation.component.SearchField
import com.sgeorgiev24.productbrowser.presentation.component.TopBar

@Composable
fun HomeContent(
    state: HomeState,
    action: (HomeAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        TopBar(
            title = stringResource(R.string.home_title),
            trailingIcon = {
                IconButton(
                    onClick = { action(HomeAction.OnFavoritesClick) }
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        tint = Color.Red,
                        contentDescription = "Favorites"
                    )
                }
            }
        )

        SearchField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.search_field_label),
            query = state.searchQuery,
            onQueryChange = { action(HomeAction.OnSearchQueryChange(it)) }
        )
    }
}