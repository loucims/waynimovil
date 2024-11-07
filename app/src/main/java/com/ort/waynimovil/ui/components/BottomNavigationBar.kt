package com.ort.waynimovil.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ort.waynimovil.R
import com.ort.waynimovil.navigation.Routes
import com.ort.waynimovil.ui.theme.WaynimovilTheme

data class NavigationItem(val route: String, val label: String, val unselectedIcon: Int, val selectedIcon: Int)

@Composable
fun BottomNavigationBar(navController: NavController, drawerState: DrawerState, handleHamburgerMenuClick: () -> Unit) {
    val items = listOf(
        NavigationItem(Routes.HOME, "Home", R.drawable.icono_home, R.drawable.icono_home_active),
        NavigationItem(Routes.ACCOUNT, "Mi Cuenta", R.drawable.icono_movimientos, R.drawable.icono_movimientos_active),
        NavigationItem(Routes.CARD, "Mi Tarjeta", R.drawable.icono_tarjeta, R.drawable.icono_tarjeta_active),
        NavigationItem(Routes.SERVICE_PAYMENT, "Servicios", R.drawable.icono_billetera, R.drawable.icono_billetera_active),
        NavigationItem("Hamburger Menu", "Menu", R.drawable.icono_menu, R.drawable.icono_menu_active)
    )

    val isDrawerOpen  = drawerState.isOpen
    val isDrawerStateChanging = drawerState.currentValue != drawerState.targetValue

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val primaryColor = MaterialTheme.colorScheme.primary

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = if (isDrawerOpen || isDrawerStateChanging) {
                index == items.lastIndex
            } else if (isDrawerStateChanging && drawerState.targetValue == DrawerValue.Closed) {
                currentRoute == item.route
            } else {
                currentRoute == item.route
            }

            val icon = if (isSelected) item.selectedIcon else item.unselectedIcon
            val animationProgress by animateFloatAsState(
                targetValue = if (isSelected) 1f else 0f,
                animationSpec = tween(durationMillis = 300),
                label = "Animacion de seleccion"
            )


            NavigationBarItem(
                modifier = Modifier
                    .drawBehind {
                        if (animationProgress > 0f) {
                            val strokeWidth = 10f
                            val halfWidth = size.width / 2
                            val startX = halfWidth - (halfWidth * animationProgress)
                            val endX = halfWidth + (halfWidth * animationProgress)

                            drawLine(
                                color = primaryColor,
                                start = Offset(startX, 0f),
                                end = Offset(endX, 0f),
                                strokeWidth = strokeWidth
                            )
                        }
                    },
                icon = {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = item.label,
                        tint = Color.Unspecified,
                    )
                },
                selected = isSelected,
                onClick = {
                    if (index == items.lastIndex) {
                        handleHamburgerMenuClick()
                    } else {
                        if (isDrawerOpen) {
                            handleHamburgerMenuClick()
                        }

                        navController.navigate(item.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = Color.Unspecified,
                    unselectedIconColor = Color.Unspecified
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    val handleHamburgerMenuClick = {}
    val context = LocalContext.current

    WaynimovilTheme {
        BottomNavigationBar(
            navController = navController,
            drawerState = DrawerState(DrawerValue.Closed),
            handleHamburgerMenuClick = handleHamburgerMenuClick
        )
    }
}