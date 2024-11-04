package com.ort.waynimovil.ui.screens.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ort.waynimovil.ui.screens.UserViewModel

@Composable
fun HomeScreen(userViewModel: UserViewModel) {
    val firstName by userViewModel.firstName.collectAsState()
    val token by userViewModel.loginToken.collectAsState()

    println("HomeScreen FirstName: $firstName")
    println("HomeScreen Token: $token")

    Text("Nombre: $firstName")
}