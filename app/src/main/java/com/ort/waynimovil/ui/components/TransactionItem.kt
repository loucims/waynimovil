package com.ort.waynimovil.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TransactionItem(date: String, description: String, amount: Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = date,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = description,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Text(
            text = formatAmount(amount),
            style = MaterialTheme.typography.bodySmall,
            color = if (amount >= 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )
    }
}

fun formatAmount(amount: Float): String {
    val formattedAmount = NumberFormat.getCurrencyInstance(Locale("es", "AR")).format(amount)
    return if (amount >= 0) "+$formattedAmount" else formattedAmount
}

@Preview
@Composable
fun TransactionItemPreview(){
    WaynimovilTheme{
        TransactionItem(
            date = "01/11/2024",
            description = "Recarga Sube",
            amount = 400f
        )
    }
}