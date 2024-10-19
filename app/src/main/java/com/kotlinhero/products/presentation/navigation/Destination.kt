package com.kotlinhero.products.presentation.navigation

import com.kotlinhero.products.domain.entity.Product
import kotlinx.serialization.Serializable

sealed interface Destination {

    @Serializable
    data object ProductsDestination : Destination

    @Serializable
    data class ProductDetailsDestination(val product: Product) : Destination
}