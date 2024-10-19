package com.kotlinhero.products.data.api

import com.kotlinhero.products.Constants
import com.kotlinhero.products.data.model.ProductModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface ProductsApi {
    suspend fun getProducts(): List<ProductModel>
}

class ProductsApiImpl(private val httpClient: HttpClient) : ProductsApi {

    override suspend fun getProducts(): List<ProductModel> {
        val response: List<ProductModel> = httpClient.get("${Constants.BASE_URL}/products").body()
        return response
    }
}
