package com.pmtaller2.OOO51722_AstridVides.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pmtaller2.OOO51722_AstridVides.models.restaurant
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Patito
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onBack: () -> Unit,
    onHomeClick: () -> Unit,
    onOrdenClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    val allDishes = remember {
        restaurant.flatMap { it.menu }
    }
    var searchQuery by remember { mutableStateOf("") }

    val filteredDishes = allDishes.filter { dish ->
        dish.name.contains(searchQuery, ignoreCase = true) ||
                dish.description.contains(searchQuery, ignoreCase = true)
    }

    val appBarColor = Purple40

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Buscar platos", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = appBarColor)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = appBarColor) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") },
                    selected = false,
                    onClick = onHomeClick
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Buscar")},
                    label = { Text("Buscar", color = Color.White) },
                    selected = true,
                    onClick = onSearchClick
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Órdenes") },
                    label = { Text("Mis Órdenes") },
                    selected = false,
                    onClick = onOrdenClick
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Buscar...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)

            )

            if (filteredDishes.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    contentAlignment = Alignment.Center

                ) {
                    Text("No se encontraron platillos.", color = Color.Gray)
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredDishes) { dish ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
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
                                Spacer(Modifier.height(8.dp))
                                Text(text = dish.name, style = MaterialTheme.typography.titleMedium)
                                Text(text = dish.description, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }
        }
    }
}

