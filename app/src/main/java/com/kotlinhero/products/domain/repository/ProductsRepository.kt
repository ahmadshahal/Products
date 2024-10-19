package com.kotlinhero.products.domain.repository

import com.kotlinhero.products.domain.entity.Product

interface ProductsRepository {
    suspend fun getProducts(): Result<List<Product>>
}
