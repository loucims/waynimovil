package com.ort.waynimovil.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ort.waynimovil.navigation.Routes

@Composable
fun LoginScreen(navController: NavController) {
    Button(onClick = {
        navController.navigate(Routes.MAIN) {
            popUpTo(Routes.LOGIN) { inclusive = true }
        }
    }) {
        Text("Ingresar")
    }
}