package com.sgeorgiev24.productbrowser.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Column {
        Text(text = "Hello, World!")

        Button(
            onClick = {
                // Handle button click
            }
        ) {
            Text(text = "Click me!")
        }
    }
}
