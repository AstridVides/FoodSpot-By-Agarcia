package com.pmtaller2.OOO51722_AstridVides.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pmtaller2.OOO51722_AstridVides.models.Dish
import com.pmtaller2.OOO51722_AstridVides.models.restaurant
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Patito
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Purple40

@Composable
fun HomeScreen(
    onRestaurantClick: (Int) -> Unit
) {
    val categories = restaurant.flatMap { it.categories }.distinct()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        categories.forEach { category ->
            item {
                Text(
                    text = category,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 8.dp,
                        bottom = 4.dp
                    )
                )
            }
            val listForCategory = restaurant.filter { it.categories.contains(category) }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    items(listForCategory) { rest ->
                        Card(
                            modifier = Modifier
                                .size(width = 200.dp, height = 240.dp)
                                .clickable { onRestaurantClick(rest.id) },
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = Patito)
                        ) {
                            Column {
                                AsyncImage(
                                    model = rest.imageUrl,
                                    contentDescription = rest.name,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(120.dp)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = rest.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    color = Color.White
                                )
                                Text(
                                    text = rest.description,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .padding(
                                            horizontal = 8.dp,
                                            vertical = 4.dp
                                        ),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onRestaurantClick = {})
}
