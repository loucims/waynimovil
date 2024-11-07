package com.ort.waynimovil.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme
import kotlinx.coroutines.launch


@Composable
fun LoanExpiringCard(onActionClick: () -> Unit) {
    val scale = remember { Animatable(1f) }
    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .scale(scale.value)
            .clip(MaterialTheme.shapes.medium)
            .shadow(
                elevation = 6.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .fillMaxWidth()
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(0.95f, animationSpec = tween(durationMillis = 100, easing = EaseInOut))
                    scale.animateTo(1f, animationSpec = tween(durationMillis = 200, easing = EaseInOut))
                }
                onActionClick()
            }
            .background(
                color = MaterialTheme.colorScheme.error,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.error)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "La cuota de tu préstamo está próxima a vencer.",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.labelLarge,
                )
                Text(
                    text = "Ver préstamo",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = "Arrow",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
fun LoanExpiringPreview(){
    WaynimovilTheme{
        LoanExpiringCard(
            onActionClick = { print("funca")}
        )
    }
}