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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection.Ltr
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuDrawer(drawerState: DrawerState, parentNavController: NavController) {
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
            }
        }
    }
}
