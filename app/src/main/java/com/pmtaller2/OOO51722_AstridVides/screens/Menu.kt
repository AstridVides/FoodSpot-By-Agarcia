package com.pmtaller2.OOO51722_AstridVides.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmtaller2.OOO51722_AstridVides.models.Restaurant
import com.pmtaller2.OOO51722_AstridVides.models.Dish
import com.pmtaller2.OOO51722_AstridVides.models.restaurant
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Purple40
import com.pmtaller2.OOO51722_AstridVides.ui.theme.PurpleGrey40
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pmtaller2.OOO51722_AstridVides.models.restaurant
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Green
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Patito

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    restaurantId: Int,
    onBack: () -> Unit,
    onHomeClick: () -> Unit,
    onOrdenClick: () -> Unit,
    onSearchClick: () -> Unit,
    onAddToOrder: (Dish) -> Unit
) {
    val context = LocalContext.current
    val currentRestaurant = restaurant.firstOrNull { it.id == restaurantId }
    val appBarColor = Purple40

    if (currentRestaurant == null) {
        Text("Restaurante no encontrado")
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentRestaurant.name) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = appBarColor),
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.White
                        )
                    }
                },
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
                    selected = false,
                    onClick = onSearchClick
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Ordenes") },
                    label = { Text("Mis Órdenes") },
                    selected = false,
                    onClick = onOrdenClick
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = currentRestaurant.description,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.Black
                )
            }

            items(currentRestaurant.menu) { dish ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Patito)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        AsyncImage(
                            model = dish.imageUrl,
                            contentDescription = dish.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),

                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = dish.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = dish.description,
                            style = MaterialTheme.typography.labelMedium,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = {
                                onAddToOrder(dish)
                                Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(Green)
                        ) {
                            Text(
                                "Agregar al carrito",
                                color = Color.White)
                        }
                    }
                }
            }
        }
    }
}