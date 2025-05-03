package com.pmtaller2.OOO51722_AstridVides.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmtaller2.OOO51722_AstridVides.models.restaurant
import com.pmtaller2.OOO51722_AstridVides.ui.components.Restaurant
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Purple40
import coil.compose.AsyncImage
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Patito

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onActionClick: (Int) -> Unit,
    onOrdenClick: () -> Unit,
    onHomeClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    val appBarColor = Purple40
    val categories = restaurant.flatMap { it.categories }.distinct()

    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = { Text("FoodSpot", color = Color.White, fontSize = 20.sp) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = appBarColor)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = appBarColor) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio", color = Color.White) },
                    selected = true,
                    onClick = onHomeClick
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Buscar")},
                    label = { Text("Buscar", color = Color.White) },
                    selected = false,
                    onClick = onSearchClick
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Mis ordenes") },
                    label = { Text("Mis Órdenes", color = Color.White) },
                    selected = false,
                    onClick = onOrdenClick
                )

            }
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
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
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 4.dp)
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
                                    .clickable { onActionClick(rest.id)},
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                colors = CardDefaults.cardColors(containerColor = Patito)
                            ) {
                                Column() {
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
                                            .padding(horizontal = 8.dp)
                                            .padding(bottom = 8.dp),
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
}
@Preview()
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onActionClick = {},
        onOrdenClick = {},
        onHomeClick = {},
        onSearchClick = {}
    )
}