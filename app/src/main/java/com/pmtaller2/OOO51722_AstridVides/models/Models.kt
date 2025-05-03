package com.pmtaller2.OOO51722_AstridVides.models

//Data class para un platillo
data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String
)

//Data class para un restaurante
data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,
    val menu: List<Dish>
)