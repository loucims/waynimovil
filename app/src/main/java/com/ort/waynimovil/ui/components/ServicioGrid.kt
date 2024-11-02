package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.R
import com.ort.waynimovil.ui.theme.WaynimovilTheme

@Composable
fun ServicioGrid(items: List<ServicioItemData>, verticalSpacing: Int, horizontalSpacing: Int) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(verticalSpacing.dp),
        horizontalArrangement = Arrangement.spacedBy(horizontalSpacing.dp)
    ) {
        items(items) { item ->
            ServicioItem(
                iconPainter = painterResource(id = item.iconRes),
                title = item.title,
                onClick = item.onClick
            )
        }
    }
}

@Preview
@Composable
fun ServicioGridPreview() {
    val items = listOf(
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR SUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR SUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR SUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR SUBE", {}),
    )

    WaynimovilTheme {
        ServicioGrid(items = items, verticalSpacing = 16, horizontalSpacing = 16)
    }
}