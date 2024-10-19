package com.kotlinhero.products.data.mapper

import com.kotlinhero.products.data.model.ProductModel
import com.kotlinhero.products.data.model.RatingModel
import com.kotlinhero.products.domain.entity.Product
import com.kotlinhero.products.domain.entity.Rating

fun ProductModel.toProduct() = Product(
    title = title,
    id = id,
    price = price,
    category = category,
    rating = rating.toRating(),
    imageUrl = imageUrl,
    description = description
)

fun RatingModel.toRating() = Rating(
    rate = rate,
    count = count
)