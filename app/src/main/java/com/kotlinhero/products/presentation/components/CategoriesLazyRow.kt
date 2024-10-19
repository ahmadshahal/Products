package com.kotlinhero.products.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kotlinhero.products.R

@Composable
fun CategoriesLazyRow(
    selectedCategory: String?,
    onCategoryClick: (String?) -> Unit,
    categories: List<String>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    ) {
        item {
            CategoryItem(
                title = stringResource(R.string.all),
                onClick = { onCategoryClick(null) },
                isSelected = selectedCategory == null
            )
        }
        items(items = categories, key = { it }) { category ->
            CategoryItem(
                title = category,
                onClick = { onCategoryClick(category) },
                isSelected = category == selectedCategory
            )
        }
    }
}

@Composable
private fun CategoryItem(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
) {
    val backgroundColor =
        if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.surface
    val foregroundColor =
        if (isSelected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onSurface
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
            color = foregroundColor
        )
    }
}