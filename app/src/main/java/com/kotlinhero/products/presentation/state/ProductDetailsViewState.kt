package com.kotlinhero.products.presentation.state

data class ProductDetailsViewState(
    val addToCartFetchState: FetchState = FetchState.Initial,
)

sealed interface ProductDetailsViewEvent {
    data object OnAddToCart : ProductDetailsViewEvent
}