package com.kotlinhero.products.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.kotlinhero.products.domain.repository.ProductsRepository
import com.kotlinhero.products.presentation.state.FetchState
import com.kotlinhero.products.presentation.state.ProductsViewEvent
import com.kotlinhero.products.presentation.state.ProductsViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val productsRepository: ProductsRepository,
) : BaseViewModel<ProductsViewState, ProductsViewEvent>() {

    private val mutableState = MutableStateFlow(ProductsViewState())
    override val state: StateFlow<ProductsViewState> get() = mutableState.asStateFlow()

    init {
        getProducts()
    }

    override fun onViewEvent(event: ProductsViewEvent) {
        when (event) {
            ProductsViewEvent.OnTryAgain -> getProducts()
            is ProductsViewEvent.OnChangeCategory -> onCategoryChange(event.category)
        }
    }

    private fun onCategoryChange(category: String?) {
        mutableState.update { it.copy(selectedCategory = category) }
        updateFilteredProducts()
    }

    /**
     *  This function is used to update the filtered products list explicitly instead of relying on
     * calculated properties within the state. The primary reason for this approach is to avoid
     * unnecessary recalculations during recomposition in Jetpack Compose.
     *
     * Calculated properties (like `get()` properties) would be re-evaluated every time the composable
     * re-renders, even if the underlying state hasn't changed. This can negatively impact performance,
     * especially with large datasets or frequent updates, as operations like filtering can be expensive.
     *
     * By explicitly computing the filtered products here, we ensure that the filtering logic only
     * runs when the state actually changes (e.g., when the selected category or product list changes).
     * This reduces computational overhead during recompositions and makes the app more efficient.
     */
    private fun updateFilteredProducts() {
        val filteredProducts = when (val selectedCategory = mutableState.value.selectedCategory) {
            null -> mutableState.value.products
            else -> mutableState.value.products.filter { it.category == selectedCategory }
        }
        mutableState.update { it.copy(filteredProducts = filteredProducts) }
    }

    private fun getProducts() {
        viewModelScope.launch {
            mutableState.update { it.copy(productsFetchState = FetchState.Loading) }
            productsRepository.getProducts().fold(
                onSuccess = { products ->
                    mutableState.update {
                        it.copy(
                            productsFetchState = FetchState.Success,
                            products = products,
                            categories = products.map { product -> product.category }.distinct(),
                        )
                    }
                    updateFilteredProducts()
                },
                onFailure = { throwable ->
                    mutableState.update {
                        it.copy(productsFetchState = FetchState.Error(throwable))
                    }
                }
            )
        }
    }
}