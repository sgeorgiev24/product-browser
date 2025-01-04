package com.sgeorgiev24.productbrowser.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sgeorgiev.productbrowser.presentation.R
import com.sgeorgiev24.productbrowser.presentation.component.ProductItem
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
            modifier = Modifier.padding(vertical = 8.dp),
            title = stringResource(R.string.home_title),
            trailingIcon = {
                IconButton(
                    onClick = { action(HomeAction.OnFavoritesClick) }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Filled.Favorite,
                        tint = Color.Red,
                        contentDescription = "Favorites"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        SearchField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.search_field_label),
            query = state.searchQuery,
            onQueryChange = { action(HomeAction.OnSearchQueryChange(it)) }
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            itemsIndexed(state.products ?: emptyList()) { index, product ->
                ProductItem(
                    id = product.id,
                    thumbnailUrl = product.thumbnail,
                    isInFavorites = false,
                    title = product.title,
                    description = product.description,
                    onFavoriteClick = {}
                )

                if (index < (state.products?.lastIndex ?: 0)) {
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    HorizontalDivider(color = Color.Gray, thickness = 1.dp)
                }
            }
        }
    }
}