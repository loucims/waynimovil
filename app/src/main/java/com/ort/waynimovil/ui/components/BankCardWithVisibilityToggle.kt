package com.ort.waynimovil.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ort.waynimovil.ui.theme.WaynimovilTheme

@Composable
fun BankCardWithVisibilityToggle(cardNumber: String, expirationDate: String) {
    var areDetailsHidden by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BankCard(cardNumber = cardNumber, expirationDate = expirationDate, hidden = areDetailsHidden)
        ShowDataButton(isActive = areDetailsHidden, onClick = { areDetailsHidden = !areDetailsHidden })
    }
}


@Preview
@Composable
fun BankCardWithVisibilityTogglePreview() {
    WaynimovilTheme {
        BankCardWithVisibilityToggle(cardNumber = "1234 5678 9012 3456", expirationDate = "12/23")
    }
}
