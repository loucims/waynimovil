package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme

@Composable
fun CardOption(title: String, description: String? = null, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .border(width = 0.5.dp, MaterialTheme.colorScheme.outline)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(12.5.dp, 16.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
            if (description != null) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(4.dp)
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(50))
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = "Ir",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(1.dp)
                    .width(24.dp)
                    .height(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun CardOptionPreview(){
    WaynimovilTheme{
        CardOption(
            title = "Prueba TextBar",
            description = null,
            onClick = { print("funca")}
        )
    }
}