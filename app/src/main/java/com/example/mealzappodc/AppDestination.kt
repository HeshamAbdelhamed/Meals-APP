package com.example.mealzappodc

sealed class Screen(val route: String) {
    object MainScreen : Screen("mainScreen")
    object MealDetailsScreen : Screen("mealDetailsScreen")
}