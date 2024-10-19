package com.kotlinhero.products.presentation.reusables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kotlinhero.products.presentation.reusables.button.BackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onNavigateUp: () -> Unit = {},
    showBackButton: Boolean = true,
    elevation: Dp = 5.dp,
    backButton: @Composable () -> Unit = {
        BackButton(onClicked = onNavigateUp)
    },
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.surface,
        titleContentColor = MaterialTheme.colorScheme.onSurface,
    ),
    actions: @Composable RowScope.() -> Unit = {}
) {
    Surface(elevation = elevation) {
        CenterAlignedTopAppBar(
            modifier = modifier,
            title = {
                title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            },
            navigationIcon = {
                if (showBackButton) {
                    backButton()
                }
            },
            actions = actions,
            colors = colors,
        )
    }
}
