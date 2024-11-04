package com.ort.waynimovil.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ort.waynimovil.ui.components.BottomNavigationBar
import com.ort.waynimovil.ui.screens.login.LoginScreen
import com.ort.waynimovil.ui.screens.SplashScreen
import com.ort.waynimovil.ui.screens.UserViewModel
import com.ort.waynimovil.ui.screens.main.CardScreen
import com.ort.waynimovil.ui.screens.main.HomeScreen
import com.ort.waynimovil.ui.screens.main.MenuDrawerScreen
import com.ort.waynimovil.ui.screens.main.ServicePaymentScreen
import com.ort.waynimovil.ui.screens.main.account.AccountScreen
import kotlinx.coroutines.launch

//ASEGURO, que no haria las cosas asi amigo, pero bueno, es lo que hay
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var shouldRenderBottomBar by remember { mutableStateOf(false) }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val scaffoldColor = if (currentRoute == Routes.SPLASH)
        MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.surface


    val userViewModel: UserViewModel = hiltViewModel()

    Scaffold(
        bottomBar = {
            if (shouldRenderBottomBar) {
                BottomNavigationBar(
                    navController = navController,
                    drawerState = drawerState,
                    handleHamburgerMenuClick = {
                        scope.launch {
                            if (drawerState.isOpen) drawerState.close()
                            else drawerState.open()
                        }
                    }
                )
            }
        },
        containerColor = scaffoldColor
    ) { padding ->

        Box(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            NavHost(
                navController = navController,
                startDestination = Routes.SPLASH,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(Routes.SPLASH) { SplashScreen(navController) }
                composable(Routes.LOGIN) { LoginScreen(navController, userViewModel, {shouldRenderBottomBar = true}) }
                composable(Routes.HOME) { HomeScreen(userViewModel) }
                composable(Routes.ACCOUNT) { AccountScreen() }
                composable(Routes.CARD) { CardScreen() }
                composable(Routes.SERVICE_PAYMENT) { ServicePaymentScreen() }
            }
        }

        val shouldRenderMenu = drawerState.isOpen || drawerState.isAnimationRunning

        if (shouldRenderMenu) {
            MenuDrawerScreen(
                parentNavController = navController,
                scope = scope,
                drawerState = drawerState
            )
        }
    }
}