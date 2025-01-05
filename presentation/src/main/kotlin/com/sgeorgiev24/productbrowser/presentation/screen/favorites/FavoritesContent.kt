package com.sgeorgiev24.productbrowser.presentation.screen.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sgeorgiev.productbrowser.presentation.R
import com.sgeorgiev24.productbrowser.presentation.component.ProductList
import com.sgeorgiev24.productbrowser.presentation.component.TopBar

@Composable
fun FavoritesContent(
    state: FavoritesState,
    action: (FavoritesAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        TopBar(
            modifier = Modifier.padding(vertical = 8.dp),
            title = stringResource(R.string.favorites_title),
            leadingIcon = {
                TextButton(
                    contentPadding = PaddingValues(0.dp),
                    onClick = { action(FavoritesAction.Back) }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = stringResource(R.string.favorites_back),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        ProductList(
            products = state.products,
            onFavoriteClick = { action(FavoritesAction.ToggleFavorite(it)) },
            onItemClick = { action(FavoritesAction.OpenProductDetails(it.id)) }
        )
    }
}