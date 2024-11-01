package com.ort.waynimovil.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ort.waynimovil.navigation.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MenuDrawer(scope: CoroutineScope, drawerState: DrawerState, parentNavController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Mi Perfil")
        HorizontalDivider()
        Button(onClick = {
            scope.launch {
                drawerState.close()
            }
            parentNavController.navigate(Routes.LOGIN) {
                popUpTo(Routes.MAIN) { inclusive = true }
            }
        }) {
            Text("Cerrar Sesión")
        }
    }
}
