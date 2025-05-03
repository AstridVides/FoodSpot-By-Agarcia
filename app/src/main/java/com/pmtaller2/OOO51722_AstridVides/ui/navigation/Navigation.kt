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
import com.pmtaller2.OOO51722_AstridVides.ui.navigation.Routes
import com.pmtaller2.OOO51722_AstridVides.ui.viewModel.OrderViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmtaller2.OOO51722_AstridVides.screens.SearchScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val orderViewModel: OrderViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(
                onActionClick = { id: Int -> navController.navigate(Routes.Menu.createRoute(id)) },
                onOrdenClick = { navController.navigate(Routes.Orden.route) },
                onHomeClick = { /* Usted se encuentra en inicia mi estimad@ */ },
                onSearchClick = { navController.navigate(Routes.Search.route) }
            )
        }

        composable(
            route = Routes.Menu.route,
            arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 1
            MenuScreen(
                restaurantId = restaurantId,
                onBack = { navController.popBackStack() },
                onHomeClick = { navController.navigate(Routes.Home.route) },
                onOrdenClick = { navController.navigate(Routes.Orden.route) },
                onAddToOrder = { dish -> orderViewModel.addOrder(dish) },
                onSearchClick = { navController.navigate(Routes.Search.route) }
            )
        }

        composable(Routes.Orden.route) {
            OrdenScreen(
                orders = orderViewModel.orders,
                onRemoveOrder = { dish -> orderViewModel.removeOrder(dish) },
                onSearchClick = { navController.navigate(Routes.Search.route) },
                onOrdenClick = { /* Usted se encuentra en mis ordenes mi estimad@ */ },
                onHomeClick = { navController.navigate(Routes.Home.route) })
        }

        composable(Routes.Search.route) {
            SearchScreen(
                onBack = {navController.popBackStack()},
                onHomeClick = { navController.navigate(Routes.Home.route) },
                onOrdenClick = { navController.navigate(Routes.Orden.route) },
                onSearchClick = {/* Usted se encuentra en buscar mi estimad@ */}
            )
        }
    }
}
