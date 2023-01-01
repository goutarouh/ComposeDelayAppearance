package com.github.goutarouh.composedelayappearance

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.goutarouh.composedelayappearance.detail.DetailScreen
import com.github.goutarouh.composedelayappearance.main.MainScreen

enum class NavDest(val route: String) {
    MAIN(route = "main"), DETAIL(route = "detail")
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavDest.MAIN.route) {
        composable(route = NavDest.MAIN.route) {
            MainScreen {
                navController.navigate(NavDest.DETAIL.route)
            }
        }
        composable(route = NavDest.DETAIL.route) {
            DetailScreen()
        }
    }
}