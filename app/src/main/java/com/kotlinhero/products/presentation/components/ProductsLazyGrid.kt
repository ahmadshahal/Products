package com.kotlinhero.products.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kotlinhero.products.R
import com.kotlinhero.products.domain.entity.Product
import com.kotlinhero.products.presentation.reusables.NetworkImage

@Composable
fun ProductsLazyGrid(
    products: List<Product>,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
    lazyGridState: LazyGridState = rememberLazyGridState(),
) {
    LazyVerticalGrid(
        modifier = modifier,
        state = lazyGridState,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
    ) {
        items(products, key = { it.id }) { product ->
            ProductItem(
                title = product.title,
                price = "$${product.price}",
                category = product.category,
                thumbnailUrl = product.imageUrl,
                rating = product.rating.rate,
                ratingCount = product.rating.count,
                onClick = { onProductClick(product) }
            )
        }
    }
}


@Composable
private fun ProductItem(
    rating: Float,
    ratingCount: Int,
    title: String,
    thumbnailUrl: String,
    category: String,
    price: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(150.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(4.dp),
    ) {
        NetworkImage(
            url = thumbnailUrl,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
        )
        Spacer(modifier = Modifier.height(8.dp))
        RatingBar(
            count = ratingCount,
            rating = rating
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = category,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = price,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun RatingBar(
    rating: Float,
    count: Int,
    modifier: Modifier = Modifier,
    maxStars: Int = 5,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        for (i in 1..maxStars) {
            val isSelected = i <= rating
            val imageResId =
                if (isSelected) R.drawable.ic_filled_star else R.drawable.ic_outlined_star
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
        }
        Text(
            "($count)",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}