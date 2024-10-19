package com.kotlinhero.products.presentation.state

sealed interface FetchState {
    data object Success : FetchState
    data class Error(val exception: Throwable) : FetchState
    data object Loading : FetchState
    data object Initial : FetchState
}