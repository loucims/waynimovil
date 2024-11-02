package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme

data class TransactionItemData(
    val date: String,
    val description: String,
    val aut: String,
    val amount: Double
)

@Composable
fun TransactionList(items: List<TransactionItemData>) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.onBackground)
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = "MOVIMIENTOS",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        LazyColumn(
            modifier = Modifier
                .shadow(
                    elevation = 6.dp,
                    spotColor = Color(0x26000000),
                    ambientColor = Color(0x26000000)
                )
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            items(items) { item ->
                TransactionItem(
                    date = item.date,
                    description = item.description,
                    aut = item.aut,
                    amount = item.amount
                )
            }
        }
    }

}

@Preview
@Composable
fun TransactionListPreview() {
    WaynimovilTheme {
        TransactionList(
            items = listOf(
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", +500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", -500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", -500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", -500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", +500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", -500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", -500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", -500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", +500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", -500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", -500.0),
                TransactionItemData("12/12/2021", "Compra en supermercado", "Aut. 394991", +500.0),
            )
        )
    }
}