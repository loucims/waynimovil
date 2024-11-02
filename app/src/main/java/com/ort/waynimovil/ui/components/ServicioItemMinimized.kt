package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.R
import com.ort.waynimovil.ui.theme.WaynimovilTheme

@Composable
fun ServicioItemMinimized(iconPainter: Painter, title: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .border(width = 0.5.dp, color = MaterialTheme.colorScheme.outline)
            .padding(1.dp)
            .width(112.dp)
            .height(96.dp)
            .clickable { onClick() }
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = "Icono",
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            textAlign = TextAlign.Center,
            text = title,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 2
        )
    }
}

@Preview
@Composable
fun ServicioItemMinimizedPreview() {
    WaynimovilTheme {
        ServicioItemMinimized(
            iconPainter = painterResource(id = R.drawable.icono_colectivo),
            title = "CARGAR \nSUBE",
            onClick = {}
        )
    }
}