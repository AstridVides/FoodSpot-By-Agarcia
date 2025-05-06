package com.pmtaller2.OOO51722_AstridVides.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pmtaller2.OOO51722_AstridVides.screens.HomeScreen
import com.pmtaller2.OOO51722_AstridVides.screens.MenuScreen
import com.pmtaller2.OOO51722_AstridVides.screens.OrdenScreen
import com.pmtaller2.OOO51722_AstridVides.screens.SearchScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmtaller2.OOO51722_AstridVides.ui.components.AppScaffold
import com.pmtaller2.OOO51722_AstridVides.ui.viewModel.OrderViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val orderViewModel: OrderViewModel = viewModel()

    AppScaffold(navController) { modifier ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            modifier = modifier
        ) {
            composable(Routes.Home.route) {
                HomeScreen(onRestaurantClick = { id ->
                    navController.navigate(Routes.Menu.createRoute(id))
                })
            }
            composable(
                route = Routes.Menu.route,
                arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
            ) { entry ->
                val id = entry.arguments?.getInt("restaurantId") ?: return@composable
                MenuScreen(
                    restaurantId = id,
                    onAddToOrder = orderViewModel::addOrder
                )
            }
            composable(Routes.Search.route) {
                SearchScreen(
                    onDishClick = { rId ->
                        navController.navigate(Routes.Menu.createRoute(rId))
                    }
                )
            }
            composable(Routes.Orden.route) {
                OrdenScreen(
                    orders = orderViewModel.orders,
                    onRemoveOrder = orderViewModel::removeOrder
                )
            }
        }
    }
}
