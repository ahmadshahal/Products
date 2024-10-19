package com.kotlinhero.products.presentation.reusables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage


@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    showShimmer: Boolean = true,
    colorFilter: ColorFilter? = null,
    contentScale: ContentScale = ContentScale.Crop,
) {
    var loading by rememberSaveable { mutableStateOf(false) }
    Box(modifier = modifier) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = url,
            contentDescription = null,
            contentScale = contentScale,
            onLoading = { loading = true },
            onSuccess = { loading = false },
            onError = { loading = false },
            colorFilter = colorFilter,
        )
        val shimmerBrush = shimmerBrush()
        AnimatedVisibility(
            visible = loading && showShimmer,
            label = "",
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = shimmerBrush)
            )
        }
    }
}