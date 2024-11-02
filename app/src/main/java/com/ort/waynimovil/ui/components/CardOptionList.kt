package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
import com.ort.waynimovil.ui.theme.WaynimovilTheme

data class CardOptionData(
    val title: String,
    val description: String? = null,
    val onClick: () -> Unit
)

@Composable
fun CardOptionList(items: List<CardOptionData>) {
    val shape = RoundedCornerShape(size = 8.dp)

    LazyColumn(
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
    ) {
        items(items) { item ->
            CardOption(
                title = item.title,
                description = item.description,
                onClick = item.onClick
            )
        }
    }
}

@Preview
@Composable
fun CardOptionListPreview() {
    WaynimovilTheme {
        CardOptionList(
            items = listOf(
                CardOptionData(
                    title = "Quiero mi tarjeta física",
                    onClick = {}
                ),
                CardOptionData(
                    title = "Ya tengo mi tarjeta física",
                    description = "Activa tu tarjeta para comenzar a usarla",
                    onClick = {}
                )
            )
        )
    }
}

@Preview
@Composable
fun CardOptionListLongPreview() {
    WaynimovilTheme {
        CardOptionList(
            items = listOf(
                CardOptionData(
                    title = "Mis Datos",
                    onClick = {}
                ),
                CardOptionData(
                    title = "Mi CVU",
                    onClick = {}
                ),
                CardOptionData(
                    title = "Configuracion",
                    onClick = {}
                ),
                CardOptionData(
                    title = "Ayuda",
                    onClick = {}
                ),
                CardOptionData(
                    title = "Terminos y condiciones",
                    onClick = {}
                )
                ,
                CardOptionData(
                    title = "Cerrar sesion",
                    onClick = {}
                )
            )
        )
    }
}

