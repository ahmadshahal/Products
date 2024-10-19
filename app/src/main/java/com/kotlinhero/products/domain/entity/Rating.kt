package com.kotlinhero.products.domain.entity

import android.os.Parcelable
import androidx.compose.runtime.Stable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
@Stable
data class Rating(
    val rate: Float,
    val count: Int
): Parcelable