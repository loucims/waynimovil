package com.ort.waynimovil.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection.Rtl
import androidx.compose.ui.unit.LayoutDirection.Ltr
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ort.waynimovil.navigation.Routes
import com.ort.waynimovil.ui.components.BottomNavigationBar
import com.ort.waynimovil.ui.components.MenuDrawer
import com.ort.waynimovil.ui.screens.main.AccountScreen
import com.ort.waynimovil.ui.screens.main.CardScreen
import com.ort.waynimovil.ui.screens.main.HomeScreen
import com.ort.waynimovil.ui.screens.main.ServicePaymentScreen
import kotlinx.coroutines.launch

@Composable
fun MainScreen(parentNavController: NavController) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    CompositionLocalProvider(LocalLayoutDirection provides Rtl) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                MenuDrawer(scope, drawerState, parentNavController)
            }
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides Ltr) {
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            navController,
                            handleHamburgerMenuClick = {
                                scope.launch { drawerState.open()
                                }
                            }
                        )
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.HOME,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(Routes.HOME) { HomeScreen() }
                        composable(Routes.ACCOUNT) { AccountScreen() }
                        composable(Routes.CARD) { CardScreen() }
                        composable(Routes.SERVICE_PAYMENT) { ServicePaymentScreen() }
                    }
                }
            }
        }
    }
}






