package com.pmtaller2.OOO51722_AstridVides.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.pmtaller2.OOO51722_AstridVides.models.Dish

class OrderViewModel : ViewModel() {
    private val _orders = mutableStateListOf<Dish>()
    val orders: List<Dish> get() = _orders

    fun addOrder(dish: Dish) {
        _orders.add(dish)
    }
    fun removeOrder(dish: Dish) {
        _orders.remove(dish)
    }
}