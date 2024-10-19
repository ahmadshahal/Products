package com.kotlinhero.products

import com.kotlinhero.products.domain.entity.Product
import com.kotlinhero.products.domain.entity.Rating

val mockProductList = listOf(
    Product(
        id = 1,
        title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
        price = 109.95f,
        description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve.",
        category = "Men's clothing",
        imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        rating = Rating(rate = 4.5f, count = 120)
    ),
    Product(
        id = 2,
        title = "Nike Air Max 270",
        price = 150.00f,
        description = "The Nike Air Max 270 delivers visible cushioning under every step with its Max Air unit.",
        category = "Footwear",
        imageUrl = "https://fakestoreapi.com/img/nike_air_max_270.jpg",
        rating = Rating(rate = 4.7f, count = 95)
    ),
    Product(
        id = 3,
        title = "Apple iPhone 13",
        price = 999.99f,
        description = "The latest iPhone with A15 Bionic chip and advanced dual-camera system.",
        category = "Electronics",
        imageUrl = "https://fakestoreapi.com/img/iphone_13.jpg",
        rating = Rating(rate = 4.8f, count = 210)
    ),
    Product(
        id = 4,
        title = "Casual Men's T-Shirt",
        price = 19.99f,
        description = "Comfortable cotton T-shirt, perfect for everyday casual wear.",
        category = "Men's clothing",
        imageUrl = "https://fakestoreapi.com/img/casual_tshirt.jpg",
        rating = Rating(rate = 4.1f, count = 50)
    ),
    Product(
        id = 5,
        title = "Samsung Galaxy Watch 4",
        price = 299.99f,
        description = "Advanced health and fitness tracking with Wear OS by Samsung.",
        category = "Electronics",
        imageUrl = "https://fakestoreapi.com/img/samsung_galaxy_watch_4.jpg",
        rating = Rating(rate = 4.6f, count = 80)
    ),
    Product(
        id = 6,
        title = "Adidas Running Shoes",
        price = 85.99f,
        description = "Lightweight and comfortable running shoes with excellent grip and durability.",
        category = "Footwear",
        imageUrl = "https://fakestoreapi.com/img/adidas_running_shoes.jpg",
        rating = Rating(rate = 4.4f, count = 135)
    )
)

val mockCategories = listOf(
    "Men's clothing",
    "Electronics",
    "Footwear",
)

val mockMensClothingProducts = listOf(
    Product(
        id = 1,
        title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
        price = 109.95f,
        description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve.",
        category = "Men's clothing",
        imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        rating = Rating(rate = 4.5f, count = 120)
    ),
    Product(
        id = 4,
        title = "Casual Men's T-Shirt",
        price = 19.99f,
        description = "Comfortable cotton T-shirt, perfect for everyday casual wear.",
        category = "Men's clothing",
        imageUrl = "https://fakestoreapi.com/img/casual_tshirt.jpg",
        rating = Rating(rate = 4.1f, count = 50)
    ),
)