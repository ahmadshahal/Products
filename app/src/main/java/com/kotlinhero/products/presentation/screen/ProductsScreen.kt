package com.kotlinhero.products.presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kotlinhero.products.R
import com.kotlinhero.products.domain.entity.Product
import com.kotlinhero.products.presentation.components.CategoriesLazyRow
import com.kotlinhero.products.presentation.components.ErrorWidget
import com.kotlinhero.products.presentation.components.ProductsLazyGrid
import com.kotlinhero.products.presentation.reusables.DefaultTopBar
import com.kotlinhero.products.presentation.state.FetchState
import com.kotlinhero.products.presentation.state.ProductsViewEvent
import com.kotlinhero.products.presentation.state.ProductsViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(
    viewState: ProductsViewState,
    onViewEvent: (ProductsViewEvent) -> Unit,
    onNavigateToProductDetails: (Product) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            DefaultTopBar(
                showBackButton = false,
                title = stringResource(R.string.app_name),
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            AnimatedContent(
                targetState = viewState.productsFetchState,
                label = "",
                contentAlignment = Alignment.Center
            ) {
                when (val state = it) {
                    is FetchState.Loading -> CircularProgressIndicator()
                    is FetchState.Initial -> Unit
                    is FetchState.Error -> ErrorWidget(
                        message = state.exception.message ?: "",
                        onClickTryAgain = { onViewEvent(ProductsViewEvent.OnTryAgain) }
                    )
                    is FetchState.Success -> Column {
                        CategoriesLazyRow(
                            categories = viewState.categories,
                            selectedCategory = viewState.selectedCategory,
                            onCategoryClick = { category ->
                                onViewEvent(
                                    ProductsViewEvent.OnChangeCategory(
                                        category = category
                                    )
                                )
                            }
                        )
                        AnimatedContent(
                            targetState = viewState.filteredProducts,
                            label = ""
                        ) { products ->
                            ProductsLazyGrid(
                                modifier = Modifier.fillMaxSize(),
                                products = products,
                                onProductClick = onNavigateToProductDetails,
                            )
                        }
                    }
                }
            }
        }
    }
}