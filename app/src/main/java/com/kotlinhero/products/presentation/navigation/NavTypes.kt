package com.kotlinhero.products.presentation.navigation

import android.net.Uri
import android.os.Build
import androidx.core.bundle.Bundle
import androidx.navigation.NavType
import com.kotlinhero.products.domain.entity.Product
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val ProductNavType = object : NavType<Product>(isNullableAllowed = false) {
    override fun put(bundle: Bundle, key: String, value: Product) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): Product {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, Product::class.java) as Product
        } else {
            bundle.getParcelable<Product>(key) as Product
        }
    }

    override fun serializeAsValue(value: Product): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun parseValue(value: String): Product {
        return Json.decodeFromString<Product>(value)
    }
}
