package com.pmtaller2.OOO51722_AstridVides.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pmtaller2.OOO51722_AstridVides.models.restaurant
import com.pmtaller2.OOO51722_AstridVides.ui.navigation.NavItem
import com.pmtaller2.OOO51722_AstridVides.ui.navigation.Routes
import com.pmtaller2.OOO51722_AstridVides.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    navController: NavHostController,
    content: @Composable (Modifier) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route ?: ""
    val appBarColor = Purple40

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    when {
                        currentRoute == Routes.Home.route -> Text("FoodSpot by Agarcia")
                        currentRoute.startsWith("Menu/") -> {
                            val restaurantId = backStackEntry.value?.arguments?.getInt("restaurantId")
                            val name = restaurant.firstOrNull { it.id == restaurantId }?.name ?: "Menú"
                            Text(name)
                        }
                        currentRoute == Routes.Orden.route -> Text("Mis ordenes")
                        currentRoute == Routes.Search.route -> Text("Buscar platillo")
                        else -> Text("")
                    }
                },
                navigationIcon = {
                    if (currentRoute != Routes.Home.route) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = appBarColor)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = appBarColor) {
                NavItem.values().forEach { item ->
                    val selected = when {
                        item.route.startsWith("Menu/") && currentRoute.startsWith("Menu/") -> true
                        else -> currentRoute == item.route
                    }
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->
        content(Modifier.padding(padding))
    }
}
