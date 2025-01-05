package com.sgeorgiev24.productbrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sgeorgiev24.productbrowser.presentation.navigation.NavigationDispatcher
import com.sgeorgiev24.productbrowser.ui.theme.ProductBrowserTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val navigationDispatcher by inject<NavigationDispatcher>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            ProductBrowserTheme {
                Scaffold(
                    modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
                ) { _ ->
                    AppRouter(
                        navigationDispatcher = navigationDispatcher,
                        navController = navController
                    )
                }
            }
        }
    }
}
