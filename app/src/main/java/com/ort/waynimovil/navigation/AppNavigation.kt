package com.ort.waynimovil.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ort.waynimovil.ui.screens.LoginScreen
import com.ort.waynimovil.ui.screens.MainScreen
import com.ort.waynimovil.ui.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) { SplashScreen(navController) }
        composable(Routes.LOGIN) { LoginScreen(navController) }
        composable(Routes.MAIN) { MainScreen(navController) }
    }
}