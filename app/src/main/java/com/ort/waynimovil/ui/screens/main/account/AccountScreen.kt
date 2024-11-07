package com.ort.waynimovil.ui.screens.main.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ort.waynimovil.R
import com.ort.waynimovil.ui.components.BalanceComponent
import com.ort.waynimovil.ui.components.ContentWrapper
import com.ort.waynimovil.ui.components.Header
import com.ort.waynimovil.ui.components.ServicioGridMinimized
import com.ort.waynimovil.ui.components.ServicioItemData
import com.ort.waynimovil.ui.components.TextButton
import com.ort.waynimovil.ui.components.TransactionItem

val servicioItems = listOf(
    ServicioItemData(R.drawable.icono_cargar_dinero, "CARGAR \nDINERO", {}),
    ServicioItemData(R.drawable.icono_extraer_dinero, "EXTRAER \nDINERO", {}),
    ServicioItemData(R.drawable.icono_transferencia, "TRANSFERIR \nDINERO", {})
)

@Composable
fun AccountScreen(viewModel: AccountViewModel = hiltViewModel()) {
    val transactions by viewModel.transactions.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchTransactions("12345")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 24.dp, 16.dp, 0.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Header(text = "Mi Cuenta")
                    ContentWrapper {
                        BalanceComponent(
                            style = MaterialTheme.typography.displayMedium,
                            labelText = "SALDO DISPONIBLE",
                            amountText = "$ 1.322,78"
                        )
                        HorizontalDivider(modifier = Modifier.padding(0.dp, 16.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = buildAnnotatedString {
                                    append("CVU: ")
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("0000654326538129540653")
                                    }
                                },
                                style = MaterialTheme.typography.labelLarge
                            )

                            TextButton(
                                text = "Copiar",
                                onClick = {},
                                textStyle = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    ServicioGridMinimized(
                        items = servicioItems
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.secondaryContainer)
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "MOVIMIENTOS",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
                if (isLoading) {
                    Box(modifier = Modifier.height(300.dp), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
            }
            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            } else {
                items(transactions) { transaction ->
                     TransactionItem(
                         date = transaction.date,
                         description = transaction.description,
                         aut = "Aut. 1234567",
                         amount = transaction.amount
                     )
                }
            }
        }
    }
}