package com.sgeorgiev24.productbrowser.presentation.component

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.sgeorgiev24.productbrowser.domain.model.product.Product

@Composable
fun ProductList(
    products: List<Product>?,
    onFavoriteClick: (Product) -> Unit,
    onItemClick: (Product) -> Unit
) {
    val configuration = LocalConfiguration.current
    val isLandScape = configuration.orientation == ORIENTATION_LANDSCAPE

    LazyVerticalGrid(
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = if (isLandScape) 12.dp else 0.dp),
        columns = GridCells.Fixed(if (isLandScape) 3 else 1)
    ) {
        itemsIndexed(products ?: emptyList()) { index, product ->
            ProductItem(
                modifier = Modifier.clickable { onItemClick(product) },
                id = product.id,
                thumbnailUrl = product.thumbnail,
                isInFavorites = product.isInFavorites,
                title = product.title,
                description = product.description,
                onFavoriteClick = { onFavoriteClick(product) }
            )

            if (index < (products?.lastIndex ?: 0)) {
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                HorizontalDivider(color = Color.Gray, thickness = 1.dp)
            }
        }
    }
}