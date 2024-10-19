package com.kotlinhero.products.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<V, T> : ViewModel() {
    abstract val state: StateFlow<V>
    abstract fun onViewEvent(event: T)
}
