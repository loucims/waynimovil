package com.ort.waynimovil.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme


@Composable
fun ShowDataButton(isActive: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
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
fun ShowData(){
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