package com.ort.waynimovil.ui.screens.main

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection.Rtl
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ort.waynimovil.ui.components.MenuDrawer
import com.ort.waynimovil.ui.screens.UserViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun MenuDrawerScreen(parentNavController: NavController, scope: CoroutineScope, drawerState: DrawerState) {

    CompositionLocalProvider(LocalLayoutDirection provides Rtl) {
        ModalNavigationDrawer(
            gesturesEnabled = drawerState.isOpen,
            drawerState = drawerState,
            drawerContent = {
                MenuDrawer(
                    drawerState = drawerState,
                    parentNavController = parentNavController
                )
            },
            content = {}
        )
    }
}