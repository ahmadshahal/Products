package com.kotlinhero.products.viewmodel

import com.kotlinhero.products.MainDispatcherRule
import com.kotlinhero.products.domain.repository.ProductsRepository
import com.kotlinhero.products.mockCategories
import com.kotlinhero.products.mockMensClothingProducts
import com.kotlinhero.products.mockProductList
import com.kotlinhero.products.presentation.state.FetchState
import com.kotlinhero.products.presentation.state.ProductsViewEvent
import com.kotlinhero.products.presentation.viewmodel.ProductsViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class ProductsViewModelTest {
    @get:Rule
    var rule: TestRule = MainDispatcherRule()

    @Mock
    private lateinit var productsRepository: ProductsRepository

    private lateinit var viewModel: ProductsViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        runBlocking {
            `when`(productsRepository.getProducts()).thenReturn(
                Result.success(
                    mockProductList
                )
            )
        }

        viewModel = ProductsViewModel(
            productsRepository
        )
    }

    @Test
    fun `when OnCategoryChange event is received, state should update correctly`() = runTest {
        // When
        viewModel.onViewEvent(ProductsViewEvent.OnChangeCategory("Men's clothing"))

        // Then
        assertEquals(viewModel.state.value.products.toSet(), mockProductList.toSet())
        assertEquals(viewModel.state.value.categories.toSet(), mockCategories.toSet())
        assertEquals(viewModel.state.value.selectedCategory, "Men's clothing")
        assertEquals(viewModel.state.value.filteredProducts.toSet(), mockMensClothingProducts.toSet())
    }

    @Test
    fun `test getShipments when viewModel is created`() = runTest {
        // Given
        `when`(productsRepository.getProducts()).thenReturn(Result.success(mockProductList))

        // When
        viewModel = ProductsViewModel(productsRepository)

        // Then
        // The first invoke happened when the viewModel was created on setup
        verify(productsRepository, times(2)).getProducts()
        assertEquals(viewModel.state.value.products.toSet(), mockProductList.toSet())
        assertEquals(viewModel.state.value.categories.toSet(), mockCategories.toSet())
        assertEquals(viewModel.state.value.selectedCategory, null)
        assertEquals(viewModel.state.value.filteredProducts.toSet(), mockProductList.toSet())
        assertEquals(viewModel.state.value.productsFetchState, FetchState.Success)
    }

    @Test
    fun `test getShipments failure state when viewModel is created`() = runTest {
        // Given
        val exception = RuntimeException("Something went wrong")
        `when`(productsRepository.getProducts()).thenReturn(Result.failure(exception))

        // When
        viewModel = ProductsViewModel(productsRepository)

        // Then
        // The first invoke happened when the viewModel was created on setup
        verify(productsRepository, times(2)).getProducts()
        assertEquals(viewModel.state.value.productsFetchState, FetchState.Error(exception))
    }
}