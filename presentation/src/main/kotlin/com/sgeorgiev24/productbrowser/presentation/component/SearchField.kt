package com.sgeorgiev24.productbrowser.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    label: String,
    query: String,
    onQueryChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = query,
        onValueChange = onQueryChange,
        label = { Text(label) },
        leadingIcon = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = ""
                )
            }
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(
                    onClick = { onQueryChange("") }
                ) {
                    Icon(
                        Icons.Filled.Clear,
                        contentDescription = ""
                    )
                }
            }
        }
    )
}