package com.kotlinhero.products.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.kotlinhero.products.domain.entity.Product
import com.kotlinhero.products.presentation.screen.ProductDetailsScreen
import com.kotlinhero.products.presentation.screen.ProductsScreen
import com.kotlinhero.products.presentation.viewmodel.ProductDetailsViewModel
import com.kotlinhero.products.presentation.viewmodel.ProductsViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.reflect.typeOf

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Destination,
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Destination.ProductsDestination> {
            val viewModel = koinViewModel<ProductsViewModel>()
            val viewState by viewModel.state.collectAsStateWithLifecycle()

            ProductsScreen(
                viewState = viewState,
                onViewEvent = viewModel::onViewEvent,
                onNavigateToProductDetails = { product ->
                    navController.navigate(
                        route = Destination.ProductDetailsDestination(
                            product = product
                        )
                    )
                }
            )
        }
        composable<Destination.ProductDetailsDestination>(
            typeMap = mapOf(typeOf<Product>() to ProductNavType)
        ) { backStackEntry ->
            val viewModel = koinViewModel<ProductDetailsViewModel>()
            val viewState by viewModel.state.collectAsStateWithLifecycle()

            val destination: Destination.ProductDetailsDestination = backStackEntry.toRoute()
            val product = destination.product

            ProductDetailsScreen(
                viewState = viewState,
                onViewEvent = viewModel::onViewEvent,
                product = product,
                onNavigateUp = navController::navigateUp
            )
        }
    }
}