package com.kotlinhero.products.di

import com.kotlinhero.products.data.api.ProductsApi
import com.kotlinhero.products.data.api.ProductsApiImpl
import com.kotlinhero.products.data.repository.ProductsRepositoryImpl
import com.kotlinhero.products.domain.repository.ProductsRepository
import com.kotlinhero.products.presentation.viewmodel.ProductDetailsViewModel
import com.kotlinhero.products.presentation.viewmodel.ProductsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val AppModule = module {
    factory { ProductsApiImpl(get()) } bind ProductsApi::class
    factory { ProductsRepositoryImpl(get()) } bind ProductsRepository::class

    viewModel { ProductsViewModel(get()) }
    viewModel { ProductDetailsViewModel() }
}
