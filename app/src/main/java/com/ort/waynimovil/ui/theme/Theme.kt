package com.ort.waynimovil.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext






private val DarkColorScheme = darkColorScheme(
    primary = Green800,
    onPrimary = White,
    primaryContainer = Green100,
    background = Gray900,
    onBackground = White,
    secondary = Yellow900,
    onSecondary = Black,
    error = Red900,
    surface = Gray500,
    onSurface = Gray100,
)

private val LightColorScheme = lightColorScheme(
    primary = Green800,
    onPrimary = White,
    primaryContainer = Green100,
    background = Gray100,
    onBackground = Black,
    secondary = Purple900,
    onSecondary = White,
    error = Red900,
    surface = White,
    onSurface = Gray900,
    outline = Gray500,
    tertiary = Green900,
)

@Composable
fun WaynimovilTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = CustomShapes,
        content = content
    )
}