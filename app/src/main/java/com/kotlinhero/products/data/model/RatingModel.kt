package com.kotlinhero.products.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingModel(
    @SerialName("rate")
    val rate: Float,

    @SerialName("count")
    val count: Int
)