package com.ort.waynimovil.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TransactionItem(date: String, description: String, aut: String = "Aut. 394991", amount: Float) {

    fun formatAmount(amount: Float): String {
        val formattedAmount = NumberFormat.getCurrencyInstance(Locale("es", "AR")).format(amount)
        return if (amount >= 0) "+$formattedAmount" else formattedAmount
    }

    Surface (
        modifier = Modifier
            .border(width = 0.5.dp, MaterialTheme.colorScheme.outline)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 8.dp),
        ) {
            Text(
                text = date,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Text(
                    text = description,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = aut,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = formatAmount(amount),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodySmall,
                color = if (amount >= 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
            )
        }
    }
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

@Preview
@Composable
fun TransactionItemNegativePreview(){
    WaynimovilTheme{
        TransactionItem(
            date = "01/11/2024",
            description = "Recarga Sube",
            amount = -1250.5f
        )
    }
}