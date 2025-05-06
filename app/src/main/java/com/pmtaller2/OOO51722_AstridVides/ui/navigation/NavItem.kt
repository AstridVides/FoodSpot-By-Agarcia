package com.pmtaller2.OOO51722_AstridVides.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavItem(val route: String, val icon: ImageVector, val label: String) {
    Home(Routes.Home.route, Icons.Default.Home, "Inicio"),
    Search(Routes.Search.route, Icons.Default.Search, "Buscar"),
    Orden(Routes.Orden.route, Icons.Default.ShoppingCart, "Mis ordenes"),

}
