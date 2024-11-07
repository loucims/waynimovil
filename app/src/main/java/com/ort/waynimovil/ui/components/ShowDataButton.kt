package com.ort.waynimovil.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme
import kotlinx.coroutines.launch


@Composable
fun ShowDataButton(isActive: Boolean, onClick: () -> Unit) {
    val scale = remember { Animatable(1f) }
    val coroutineScope = rememberCoroutineScope()


    Row(
        modifier = Modifier
            .scale(scale.value)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(0.9f, animationSpec = tween(durationMillis = 100, easing = EaseInOut))
                    scale.animateTo(1f, animationSpec = tween(durationMillis = 200, easing = EaseInOut))
                }
                onClick()
            }
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = if (isActive) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
            contentDescription = "Mostrar datos",
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .padding(0.dp, 2.dp, 0.dp, 0.dp)
                .width(24.dp)
                .height(24.dp)
                .padding(start = 1.33333.dp, top = 3.33333.dp, end = 1.33333.dp, bottom = 3.33333.dp)

        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(

            textAlign = TextAlign.Center,
            text = "Mostrar datos",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
fun ShowDataPreview(){
    WaynimovilTheme{
        ShowDataButton(
            isActive = true,
            onClick = { print("funca")}
        )
    }
}

@Preview
@Composable
fun HideData(){
    WaynimovilTheme{
        ShowDataButton(
            isActive = false,
            onClick = { print("funca")}
        )
    }
}