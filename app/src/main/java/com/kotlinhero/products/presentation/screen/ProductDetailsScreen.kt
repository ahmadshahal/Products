package com.kotlinhero.products.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kotlinhero.products.R
import com.kotlinhero.products.domain.entity.Product
import com.kotlinhero.products.presentation.reusables.DefaultTopBar
import com.kotlinhero.products.presentation.reusables.NetworkImage
import com.kotlinhero.products.presentation.state.ProductDetailsViewEvent
import com.kotlinhero.products.presentation.state.ProductDetailsViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    product: Product,
    viewState: ProductDetailsViewState,
    onViewEvent: (ProductDetailsViewEvent) -> Unit,
    onNavigateUp: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            DefaultTopBar(onNavigateUp = onNavigateUp)
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .shadow(elevation = 24.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 16.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    onClick = { onViewEvent(ProductDetailsViewEvent.OnAddToCart) },
                    shape = CircleShape,
                ) {
                    Text(
                        text = stringResource(R.string.add_to_cart).uppercase(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            NetworkImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                url = product.imageUrl,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    modifier = Modifier.weight(1F),
                    text = product.title,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = product.category,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(8.dp))
            RatingBar(
                modifier = Modifier.padding(horizontal = 16.dp),
                rating = product.rating.rate,
                count = product.rating.count
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = product.description,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
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
                modifier = Modifier.size(16.dp)
            )
        }
        Text(
            "($count)",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}