package com.ort.waynimovil.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.components.BankCardWithVisibilityToggle
import com.ort.waynimovil.ui.components.CardOptionData
import com.ort.waynimovil.ui.components.CardOptionList
import com.ort.waynimovil.ui.components.Header

@Composable
fun CardScreen() {
    Text(text = "Card Screen")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        
        Header(text = "Mi Tarjeta")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 12.dp, end = 12.dp),

            ){

            Text(
                text = "TARJETA VIRTUAL",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)

        ){
            BankCardWithVisibilityToggle(cardNumber = "4957 0704 0707 5824", expirationDate = "05/23")
        }


        Spacer(modifier = Modifier.height(20.dp))

        HorizontalDivider(modifier = Modifier.background(MaterialTheme.colorScheme.outline))

        Spacer(modifier = Modifier.height(24.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 12.dp, end = 12.dp),
        ){
            Text(
                text = "\uD83D\uDCA1 ¿Sabías que poder pedir una tarjeta Mastercard física para utilizar directamente en los negocios que vos elijas?",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 12.dp, end = 12.dp),

            ){

            Text(
                text = "TARJETA FÍSICA",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 12.dp, end = 12.dp)

        ){

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


}