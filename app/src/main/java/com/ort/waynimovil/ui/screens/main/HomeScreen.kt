package com.ort.waynimovil.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ort.waynimovil.R
import com.ort.waynimovil.ui.components.BalanceComponent
import com.ort.waynimovil.ui.components.BankCardWithVisibilityToggle
import com.ort.waynimovil.ui.components.BankCardWithVisibilityTogglePreview
import com.ort.waynimovil.ui.components.LoanExpiringCard
import com.ort.waynimovil.ui.components.ServicioGridMinimized
import com.ort.waynimovil.ui.components.ServicioItemData
import com.ort.waynimovil.ui.screens.UserViewModel
import java.util.Locale

@Composable
fun HomeScreen(userViewModel: UserViewModel) {
    val firstName by userViewModel.firstName.collectAsState()
    val token by userViewModel.loginToken.collectAsState()

    val items = listOf(
        ServicioItemData(R.drawable.icono_cargar_dinero, "CARGAR \nDINERO", {}),
        ServicioItemData(R.drawable.icono_extraer_dinero, "EXTRAER \nDINERO", {}),
        ServicioItemData(R.drawable.icono_prestamos, "SEGUIR \nMI PRÉSTAMO", {}),
        ServicioItemData(R.drawable.icono_colectivo, "RECARGA \nSUBE", {}),
        ServicioItemData(R.drawable.icono_celular, "RECARGA \nCELULAR", {}),
        ServicioItemData(R.drawable.icono_pago_servicio, "PAGAR \nSERVICIO", {})
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 24.dp, start = 12.dp, end = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 12.dp)
        ) {
            Text(
                text = "👋 Hola ${firstName?.capitalize(Locale.ROOT)}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
                )

            Text(
                text = "Ultimo acceso: Mar 01, 2020 4:55 PM",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface
            )

        }

        Spacer(modifier = Modifier.height(24.dp))
        
        
        BankCardWithVisibilityToggle(cardNumber = "4957 0704 0707 5824", expirationDate = "05/23")

        Spacer(modifier = Modifier.height(20.dp))
        
        BalanceComponent(style = MaterialTheme.typography.displayMedium)

        Spacer(modifier = Modifier.height(24.dp))

        LoanExpiringCard {}

        Spacer(modifier = Modifier.height(24.dp))

        ServicioGridMinimized(
            items = items
        )



    }
}