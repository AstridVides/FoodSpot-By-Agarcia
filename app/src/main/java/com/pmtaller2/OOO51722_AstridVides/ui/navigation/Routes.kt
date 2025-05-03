package com.pmtaller2.OOO51722_AstridVides.ui.navigation

sealed class Routes(val route: String) {
    data object Main: Routes("Main")
    data object Home : Routes("Home")
    data object Orden : Routes("Orden")
    data object Menu : Routes("Menu/{restaurantId}") {
        fun createRoute(restaurantId: Int): String = "Menu/$restaurantId"
    }
    data object Search : Routes("Search")
}