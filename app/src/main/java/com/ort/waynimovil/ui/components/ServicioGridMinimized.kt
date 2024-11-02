package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

data class ServicioItemData(
    val iconRes: Int,
    val title: String,
    val onClick: () -> Unit
)

@Composable
fun ServicioGridMinimized(columnsQuantity: Int, items: List<ServicioItemData>) {
    val shape = RoundedCornerShape(size = 8.dp)


    LazyVerticalGrid(
        modifier = Modifier
            .shadow(
                elevation = 6.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .border(width = 1.dp, color = MaterialTheme.colorScheme.outline, shape = shape)
            .clip(shape = shape)
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surface)
        ,
        columns = GridCells.Fixed(columnsQuantity)
    ) {
        items(items) { item ->
            ServicioItemMinimized(
                iconPainter = painterResource(id = item.iconRes),
                title = item.title,
                onClick = item.onClick
            )
        }
    }
}

@Preview
@Composable
fun ServicioGridMinimizedPreview() {
    val items = listOf(
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {})
    )

    WaynimovilTheme {
        ServicioGridMinimized(
            columnsQuantity = 3,
            items = items
        )
    }
}

@Preview
@Composable
fun ServicioGridMinimizedLongPreview() {
    val items = listOf(
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {}),
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR \nSUBE", {})
    )

    WaynimovilTheme {
        ServicioGridMinimized(
            columnsQuantity = 3,
            items = items
        )
    }
}