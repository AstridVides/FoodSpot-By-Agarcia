package com.pmtaller2.OOO51722_AstridVides.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pmtaller2.OOO51722_AstridVides.models.restaurant
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Patito
import androidx.compose.foundation.clickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onDishClick: (restaurantId: Int) -> Unit
) {
    val allRestaurants = remember { restaurant }
    val allDishes = allRestaurants.flatMap { it.menu }
    var searchQuery by remember { mutableStateOf("") }
    val filteredDishes = allDishes.filter { dish ->
        dish.name.contains(searchQuery, ignoreCase = true) ||
                dish.description.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar platillos...", color = Color.Black) },
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                cursorColor = Color.Black,
                /*placeholderColor = Color.Black,
                textColor = Color.Black*/
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        if (filteredDishes.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No se encontraron platillos.")
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredDishes) { dish ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val restaurantId = allRestaurants.first {
                                    it.menu.contains(dish)
                                }.id
                                onDishClick(restaurantId)
                            },
                        colors = CardDefaults.cardColors(containerColor = Patito)
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            AsyncImage(
                                model = dish.imageUrl,
                                contentDescription = dish.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = dish.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = dish.description,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        onDishClick = {}
    )
}