package com.ort.waynimovil.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection.Ltr
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ort.waynimovil.ui.screens.UserViewModel

@Composable
fun MenuDrawer(drawerState: DrawerState, parentNavController: NavController) {
    val userViewModel: UserViewModel = hiltViewModel()
    val firstName by userViewModel.firstName.collectAsState()
    val lastName by userViewModel.lastName.collectAsState()
    val token by userViewModel.loginToken.collectAsState()

    CompositionLocalProvider(LocalLayoutDirection provides  Ltr) {
        ModalDrawerSheet(
            modifier = Modifier
                .then(
                    if (drawerState.targetValue == DrawerValue.Open) Modifier.fillMaxSize() else Modifier
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("Mi info")
                HorizontalDivider()
                Text("Nombre: $firstName")
                Text("Apellido: $lastName")
                Text(text = "Token: $token")
            }
        }
    }
}
