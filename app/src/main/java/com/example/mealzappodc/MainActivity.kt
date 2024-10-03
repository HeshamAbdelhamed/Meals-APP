package com.example.mealzappodc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzappodc.ui.screens.mainscreen.MainScreen
import com.example.mealzappodc.ui.screens.mealdetails.MealDetailsScreen
import com.example.mealzappodc.ui.theme.MealzAppODCTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealzAppODCTheme {
                MealsAppCompose()
            }
        }
    }
}

@Composable
fun MealsAppCompose() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) { MainScreen(navController) }
        composable(
            "${Screen.MealDetailsScreen.route}/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { MealDetailsScreen() }
    }
}