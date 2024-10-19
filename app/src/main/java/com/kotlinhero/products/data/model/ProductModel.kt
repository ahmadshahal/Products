package com.kotlinhero.products.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductModel(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("price")
    val price: Float,

    @SerialName("description")
    val description: String,

    @SerialName("category")
    val category: String,

    @SerialName("image")
    val imageUrl: String,

    @SerialName("rating")
    val rating: RatingModel
)
