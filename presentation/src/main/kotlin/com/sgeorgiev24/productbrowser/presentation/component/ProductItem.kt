package com.sgeorgiev24.productbrowser.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    id: Int,
    thumbnailUrl: String,
    isInFavorites: Boolean,
    title: String,
    description: String,
    onFavoriteClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                alignment = Alignment.Center,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(thumbnailUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            IconButton(
                modifier = Modifier.align(Alignment.TopEnd).padding(8.dp),
                onClick = { onFavoriteClick(id) }
            ) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = if (isInFavorites) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    tint = if (isInFavorites) Color.Red else Color.Gray,
                    contentDescription = ""
                )
            }
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))
    }
}