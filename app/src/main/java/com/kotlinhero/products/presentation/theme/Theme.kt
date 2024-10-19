package com.kotlinhero.products.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Black,
    secondary = Gray,
    background = LightGray,
    onPrimary = White,
    onBackground = Black,
    surface = White,
    onSurface = Black
)

@Composable
fun ProductsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}