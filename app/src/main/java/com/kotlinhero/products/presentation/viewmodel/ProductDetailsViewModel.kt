package com.kotlinhero.products.presentation.viewmodel

import com.kotlinhero.products.presentation.state.ProductDetailsViewEvent
import com.kotlinhero.products.presentation.state.ProductDetailsViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailsViewModel : BaseViewModel<ProductDetailsViewState, ProductDetailsViewEvent>() {

    private val mutableState = MutableStateFlow(ProductDetailsViewState())
    override val state: StateFlow<ProductDetailsViewState> get() = mutableState.asStateFlow()

    override fun onViewEvent(event: ProductDetailsViewEvent) {
        when(event) {
            ProductDetailsViewEvent.OnAddToCart -> Unit
        }
    }
}