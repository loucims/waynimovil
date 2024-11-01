package com.ort.waynimovil.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.ort.waynimovil.ui.theme.WaynimovilTheme

@Composable
fun BalanceComponent(style: TextStyle, labelText: String = "SALDO DISPONIBLE", amountText: String = "$ 1.322,78") {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = labelText,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = amountText,
            color = MaterialTheme.colorScheme.onBackground,
            style = style
        )
    }
}

@Preview
@Composable
fun BalanceAvailablePreview(){
    WaynimovilTheme{
        BalanceComponent(
            style = MaterialTheme.typography.displayMedium,
            labelText = "SALDO DISPONIBLE",
            amountText = "$ 1.322,78"
        )
    }
}
