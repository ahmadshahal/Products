package com.kotlinhero.products.domain.entity

import android.os.Parcelable
import androidx.compose.runtime.Stable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Stable
@Parcelize
@Serializable
data class Product(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val imageUrl: String,
    val rating: Rating
): Parcelable
