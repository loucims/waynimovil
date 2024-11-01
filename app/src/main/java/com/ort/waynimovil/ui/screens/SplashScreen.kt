package com.ort.waynimovil.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.ort.waynimovil.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(Routes.LOGIN) {
            popUpTo(Routes.SPLASH) { inclusive = true }
        }
    }

    Text(text = "Splash Screen")
}