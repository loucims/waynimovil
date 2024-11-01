package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme


@Composable
fun LoanReminderCard(onActionClick: () -> Unit) {
    Row(
        modifier = Modifier
            .shadow(elevation = 6.dp, spotColor = Color(0x26000000), ambientColor = Color(0x26000000))
            .width(336.dp)
            .height(48.dp)
            .background(color = MaterialTheme.colorScheme.error, shape = RoundedCornerShape(size = 8.dp))
            .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp)

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
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.clickable(onClick = onActionClick)
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

@Preview
@Composable
fun LoanExpiringPreview(){
    WaynimovilTheme{
        LoanReminderCard(
            onActionClick = { print("funca")}
        )
    }
}