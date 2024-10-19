package com.kotlinhero.products.presentation.state

import com.kotlinhero.products.domain.entity.Product

data class ProductsViewState(
    val productsFetchState: FetchState = FetchState.Initial,
    val products: List<Product> = emptyList(),
    val filteredProducts: List<Product> = emptyList(),
    val categories: List<String> = emptyList(),
    val selectedCategory: String? = null,
)

sealed interface ProductsViewEvent {
    data object OnTryAgain: ProductsViewEvent
    data class OnChangeCategory(val category: String?): ProductsViewEvent
}