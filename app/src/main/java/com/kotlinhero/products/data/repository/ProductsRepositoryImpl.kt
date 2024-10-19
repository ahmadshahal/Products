package com.kotlinhero.products.data.repository

import com.kotlinhero.products.data.api.ProductsApi
import com.kotlinhero.products.data.mapper.toProduct
import com.kotlinhero.products.domain.entity.Product
import com.kotlinhero.products.domain.repository.ProductsRepository

class ProductsRepositoryImpl(
    private val productsApi: ProductsApi
) : ProductsRepository {

    override suspend fun getProducts(): Result<List<Product>> = runCatching {
        productsApi.getProducts().map { it.toProduct() }
    }
}
