package com.ort.waynimovil.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ort.waynimovil.R
import com.ort.waynimovil.navigation.Routes

data class NavigationItem(val route: String, val label: String, val unselectedIcon: Int, val selectedIcon: Int)

@Composable
fun BottomNavigationBar(navController: NavController, handleHamburgerMenuClick: () -> Unit) {
    val items = listOf(
        NavigationItem(Routes.HOME, "Home", R.drawable.icono_home, R.drawable.icono_home_active),
        NavigationItem(Routes.ACCOUNT, "Mi Cuenta", R.drawable.icono_movimientos, R.drawable.icono_movimientos_active),
        NavigationItem(Routes.CARD, "Mi Tarjeta", R.drawable.icono_tarjeta, R.drawable.icono_tarjeta_active),
        NavigationItem(Routes.SERVICE_PAYMENT, "Servicios", R.drawable.icono_billetera, R.drawable.icono_billetera_active),
        NavigationItem("Hamburger Menu", "Menu", R.drawable.icono_menu, R.drawable.icono_menu_active)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEachIndexed { index, item ->
            val isSelected = currentRoute == item.route
            val icon = if (isSelected) item.selectedIcon else item.unselectedIcon

            NavigationBarItem(
                icon = { Icon(
                    painter = painterResource(id = icon),
                    contentDescription = item.label,
                    tint = Color.Unspecified
                ) },
                selected = isSelected,
                onClick = {
                    if (index == items.lastIndex) {
                        handleHamburgerMenuClick()
                    } else {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                    }
                }
            )
        }

    }
}