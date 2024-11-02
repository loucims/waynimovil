package com.ort.waynimovil.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme


@Composable
fun ShowDataButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.Call,
            contentDescription = "Mostrar datos",
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .width(16.dp)
                .height(16.dp)
                .padding(start = 1.33333.dp, top = 3.33333.dp, end = 1.33333.dp, bottom = 3.33333.dp)

        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
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
            onClick = { print("funca")}
        )
    }
}